package com.example.socialnet.test;

import com.example.socialnet.utils.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

/**
 * @description TODO
 * @authors XiaoYu
 * @date 2022/8/27 9:04
 */
public class Consumer {
    //    队列的名称
    public static final String QUEUE_NAME = "hello";

    public static int byteArrayToInt(byte[] bytes) {

        int value = 0;

//由高位到低位

        for (int i = 0; i < 4; i++) {

            int shift = (4 - 1 - i) * 8;

            value += (bytes[i] & 0x000000FF) << shift;//往高位游

        }

        return value;

    }

    //    接收消息
    public static void main(String[] args) throws Exception {
//        发送数字
//        Channel channel = RabbitMqUtils.getChannel();
//
////        消息的接收
//        DeliverCallback deliverCallback = (var1, var2) -> System.out.println("接受到的消息：" + byteArrayToInt(var2.getBody()));
////        消息接收被取消时，会执行下面的内容
//        CancelCallback cancelCallback = var1 -> System.out.println(var1 + "消费者取消消费接口回调逻辑");
//
//        System.out.println("C2等待接收消息...");
//        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
        Channel channel = RabbitMqUtils.getChannel();

//        消息的接收
        DeliverCallback deliverCallback = (var1, var2) -> System.out.println("接受到的消息：" + new String(var2.getBody()));
//        消息接收被取消时，会执行下面的内容
        CancelCallback cancelCallback = var1 -> System.out.println(var1 + "消费者取消消费接口回调逻辑");

        System.out.println("C2等待接收消息...");
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}
