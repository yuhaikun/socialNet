package com.example.socialnet.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;



/**
 * @description TODO
 * @authors XiaoYu
 * @date 2022/8/27 8:55
 */
public class RabbitMqUtils {
//    得到一个连接的channel
    public static Channel getChannel() throws Exception {
//        创建一个连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("1.12.254.160");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        Connection connection = connectionFactory.newConnection();
        com.rabbitmq.client.Channel channel = connection.createChannel();
        return channel;
    }
}
