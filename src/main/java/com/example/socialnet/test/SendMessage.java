package com.example.socialnet.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.socialnet.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

import static com.example.socialnet.constants.Constants.QUEUE_NAME;

/**
 * @description TODO
 * @authors XiaoYu
 * @date 2022/11/9 8:55
 */
public class SendMessage {

    private Channel channel;

    SendMessage() throws Exception {
        channel = RabbitMqUtils.getChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    }

    public static String readFile(String jsonFile, int index) throws Exception {

//        rwl.readLock().lock();
        JSONObject x;

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
//         String text = x.getString("text");

        // x.put("account", this.socialNode.getAccountAddress());

        return x.toString();
    }

    public static void main(String[] args) throws Exception {
        SendMessage sendMessage = new SendMessage();
        for (int i = 0; i < 10; i++) {
            String s = readFile("E:\\projects\\dataHandle\\falseData.json", i);
            System.out.println("s = " + s);
            sendMessage.channel.basicPublish("", QUEUE_NAME, null, s.getBytes(StandardCharsets.UTF_8));
        }

    }
}
