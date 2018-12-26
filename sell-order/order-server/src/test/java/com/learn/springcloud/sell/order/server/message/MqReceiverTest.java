package com.learn.springcloud.sell.order.server.message;

import com.learn.springcloud.sell.order.server.OrderApplicationTests;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * 发送mq消息测试
 *
 * @author yFoo
 * @date 2018-12-26
 */
public class MqReceiverTest extends OrderApplicationTests {

    @Autowired
    AmqpTemplate amqpTemplate;

    @Test
    public void send() {
        amqpTemplate.convertAndSend("myQueue", "now " + new Date());
    }

    @Test
    public void sendComputer() {
        amqpTemplate.convertAndSend("orderExchange", "computer", "now: " + new Date());
    }

    @Test
    public void sendFruit() {
        amqpTemplate.convertAndSend("orderExchange", "fruit", "now: " + new Date());
    }
}