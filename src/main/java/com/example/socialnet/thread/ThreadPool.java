package com.example.socialnet.thread;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.socialnet.entities.SocialNode;
import com.example.socialnet.utils.RabbitMqUtils;
import com.example.socialnet.utils.RsaUtils;
import com.rabbitmq.client.Channel;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static com.example.socialnet.constants.Constants.*;

/**
 * @description TODO
 * @authors XiaoYu
 * @date 2022/8/27 8:51
 */
class NumberThread implements Runnable {

    private static int fileNumber = 0;
    private static int number = 0;
    // 2. 实例化读写锁
    private static ReadWriteLock rwl = new ReentrantReadWriteLock();
    public long startTime;
    public long endTime;
    private Channel channel;

    private RsaUtils rsaUtils;
    //    private Web3Application web3Application;
    private SocialNode socialNode;
    // 1.实例化锁
    private ReentrantLock lock = new ReentrantLock();
    //    加上condition，用于控制多线程之间的、基于该状态的条件等待
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();


    /**
     * 构造函数只运行一次
     *
     * @param start
     * @throws Exception
     */
    NumberThread(long start) throws Exception {
        this.startTime = start;
//        Init();
        channel = RabbitMqUtils.getChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        this.rsaUtils = new RsaUtils();
        rsaUtils.importPublicKey(PUBLICKEYPATH);
    }

    public static byte[] intToByteArray(int i) {

        byte[] result = new byte[4];

//由高位到低位

        result[0] = (byte) ((i >> 24) & 0xFF);

        result[1] = (byte) ((i >> 16) & 0xFF);

        result[2] = (byte) ((i >> 8) & 0xFF);

        result[3] = (byte) (i & 0xFF);

        return result;

    }

    /**
     * @param jsonFile
     * @return
     * @throws Exception 该方法用static修饰，在这种情况下真正的只能有一个线程进入到add代码块
     *                   因为用static修饰的话是所有对象公共的，因此和前面的那种情况不同，不存在两个
     *                   线程同一时刻执行add方法
     */
    public static String readFile(String jsonFile) throws Exception {


        /**
         * 在对数据进行读写的时候，为了保证数据的一致性和完整性，需要读和写是互斥的，写和写是互斥的，但是读和读
         * 是不需要互斥的，这样读和读不互斥性能更高些。
         */
        rwl.readLock().lock();
        StringBuffer stringBuffer;
        try {
            FileInputStream fileInputStream = new FileInputStream(jsonFile);

            int len;
            byte[] bytes = new byte[1024];
            stringBuffer = new StringBuffer();
            while ((len = fileInputStream.read(bytes)) != -1) {
                //            添加字符串到缓冲区
                stringBuffer.append(new String(bytes, 0, len));
            }
//            关闭资源
            fileInputStream.close();
        } finally {
            rwl.readLock().unlock();
        }


        return stringBuffer.toString();
    }

    /**
     * 从生成的json文件中读取账户信息
     */
    public static List<String> readAccountsFromFiles() throws Exception {
        fileNumber += 1;

        ArrayList<String> strings = new ArrayList<>();
        String fileName = "./wallet/account_" + Integer.toString(fileNumber) + ".json";
        String jsonData = readFile(fileName);
//        转json对象
        JSONObject parse = (JSONObject) JSONObject.parse(jsonData);
        String address = parse.getString("address");
        address = "0x" + address;
        strings.add(fileName);
        strings.add(address);

        return strings;

    }


    /**
     * @param jsonFile
     * @param index
     * @return
     * @throws Exception 重载readFile函数，用于读取发送信息的json文件
     */
    public String readFile(String jsonFile, int index) throws Exception {

//        rwl.readLock().lock();
        JSONObject x;
        try {
            FileInputStream fileInputStream = new FileInputStream(jsonFile);

            int len;
            byte[] bytes = new byte[1024];
            StringBuffer stringBuffer = new StringBuffer();
            while ((len = fileInputStream.read(bytes)) != -1) {
                //            添加字符串到缓冲区
                stringBuffer.append(new String(bytes, 0, len));
            }
//            关闭资源
            fileInputStream.close();


//            使用fastjson将字符串转换成json
            JSONArray jsonArray = JSONObject.parseArray(stringBuffer.toString());

//        System.out.println("大小为：" + jsonArray.size());
//            便于对象去除我们需要的数据
//        for (Object schema :
//                jsonArray) {
//            JSONObject x = (JSONObject) schema;
//            System.out.println("发送的信息是：" + x);
//        }
            x = (JSONObject) jsonArray.get(index);
//            对发送的信息进行签名，将签名后的信息一并发送，在服务器端进行验证
            String text = x.getString("text");
            String sign_message = this.socialNode.web3Application.sign_Message(text);
//            System.out.println("sign_message = " + sign_message);
            x.put("sign_message", sign_message);
            x.put("account", this.socialNode.getAccountAddress());
        } finally {
//            rwl.readLock().unlock();
        }
        return x.toString();
    }

    @SneakyThrows
    @Override
    public void run() {

//         Init();
//        synchronized (this) {
//            Init();
////            System.out.println("当前线程为： " +  Thread.currentThread().getName() + "\t" + this.socialNode.getAccountAddress());
//        }

//        lock.lock();
//        Init();
//        System.out.println("当前线程为： " +  Thread.currentThread().getName() + "\t" + this.socialNode.getAccountAddress());
//        lock.unlock();

//        System.out.println(this.socialNode.getAccountAddress());
//        int memberReputationValue = web3Application.getMemberReputationValue("0x7A379e91178c2b3B19175F6b95F581Ee1255E111");
//        System.out.println("信誉值为:"+memberReputationValue);

//        所有线程一直运行，一直竞争资源
        while (!Thread.currentThread().isInterrupted()) {

//              留下多线程竞争的时间
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


//            if (number >= 20) {
//                break;
//            }
            lock.lock();
            try {
                if (number >= 20) {
                    break;
                }
                Init();

                for (int i = 0; i < 2; i++) {
                    //                    channel = RabbitMqUtils.getChannel();
                    //                    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
                    //                System.out.println(Thread.currentThread().getName() + "：" + number);
                    //                String tempString = sendMessage.getMessage(1);
                    String s = readFile(JSONFILE_1, number);



                    //      发送的信息进行RSA加密
                    String encryptString = rsaUtils.encrypt(s);
                    channel.basicPublish("", QUEUE_NAME, null, encryptString.getBytes(StandardCharsets.UTF_8));
                    System.out.println(Thread.currentThread().getName() + ":" + encryptString + "\n" + "发送第 " + number + " 条消息");
                    number++;
                }
                if (number == 20) {
                    endTime = System.currentTimeMillis();
                    System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
                }

            } finally {
                lock.unlock();
            }


        }


//        每个线程只运行一次
//        lock.lock();
//        try {
////            while (number >= 20) {
////                endTime=System.currentTimeMillis();
////                System.out.println("程序运行时间："+ (endTime-startTime) + "ms");
////                notFull.await();
////            }
//            Init();
//            for (int i = 0; i < 2; i++) {
//
////                channel = RabbitMqUtils.getChannel();
////                channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//                String s = readFile(JSONFILE_1, number);
////                channel.basicPublish("", QUEUE_NAME, null, intToByteArray(number));
//                channel.basicPublish("", QUEUE_NAME, null, s.getBytes(StandardCharsets.UTF_8));
//                System.out.println(Thread.currentThread().getName() + ":" + s + "\n" + "发送第 " + number + " 条消息");
//                number++;
//            }
//            if (number >= 20) {
//                endTime=System.currentTimeMillis();
//                System.out.println("程序运行时间："+ (endTime-startTime) + "ms");
////                notFull.await();
//            }
//        } finally {
//            lock.unlock();
//        }

//
//
//        System.out.println(Thread.currentThread().getName() + ":" + number);

//
//        number++;
//        lock.unlock();
    }

    /**
     * 初始化web3账户，方便后续调用合约
     */
    public void Init() throws Exception {

        List<String> strings = readAccountsFromFiles();
        System.out.println("strings = " + strings);
        this.socialNode = new SocialNode(strings.get(0), strings.get(1));

//        this.web3Application = new Web3Application(PASSWD, wallet);

    }

}

public class ThreadPool {
    public static void main(String[] args) throws Exception {
        /*
//        创建固定线程个数
        ExecutorService executorService = Executors.newFixedThreadPool(10);

//        new一个Runnable接口的对象
        NumberThread number = new NumberThread();

//        执行线程，最多十个(适合适用于Runnable)
//        executorService.execute(number);
//        执行线程，适用于callable
        executorService.submit(number);


//        关闭线程池
        executorService.shutdown();


         */
        long startTime = System.currentTimeMillis();

        NumberThread thread = new NumberThread(startTime);

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        try {
            for (int i = 0; i < 10; i++) {
//                使用线程池来创建线程
                threadPool.execute(new Thread(thread));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}
