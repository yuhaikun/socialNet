package com.example.socialnet;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.socialnet.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.example.socialnet.constants.Constants.JSONFILE_1;
import static com.example.socialnet.constants.Constants.QUEUE_NAME;


/**
 * @description TODO
 * @authors XiaoYu
 * @date 2022/10/21 15:42
 */
public class TestAll {

    //    测试方法，发送一条信息
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String s = readFile(JSONFILE_1, 1);
        //                channel.basicPublish("", QUEUE_NAME, null, intToByteArray(number));
        channel.basicPublish("", QUEUE_NAME, null, s.getBytes(StandardCharsets.UTF_8));
        System.out.println(Thread.currentThread().getName() + ":" + s + "\n" + "发送第 " + 1 + " 条消息");
    }

    private static String readFile(String jsonfile, int index) throws IOException {
        JSONObject x;
        try {
            FileInputStream fileInputStream = new FileInputStream(jsonfile);

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
//            String text = x.getString("text");
//            String sign_message = this.socialNode.web3Application.sign_Message(text);
////            System.out.println("sign_message = " + sign_message);
//            x.put("sign_message", sign_message);
//            x.put("account", this.socialNode.getAccountAddress());
        } finally {
//            rwl.readLock().unlock();
        }
        return x.toString();

    }
}
