package com.learn.springcloud.sell.order.server.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收MQ消息
 *
 * @author yFoo
 * @date 2018-12-26
 */
@Component
@Slf4j
public class MqReceiver {

    // 1. @RabbitListener(queues = "myQueue")
    // 2. 自动创建队列
    // @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    // 3. 自动创建，Exchange和Queue绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message) {
        log.info("MqReceiver: {}", message);
    }

    /**
     * 数码供应商服务 接收消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("orderExchange"),
            key = "computer",
            value = @Queue("computerQueue")
    ))
    public void computerProcess(String message) {
        log.info("computer MqReceiver: {}", message);
    }

    /**
     * 水果供应商服务 接收消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("orderExchange"),
            key = "fruit",
            value = @Queue("fruitQueue")
    ))
    public void fruitProcess(String message) {
        log.info("fruit MqReceiver: {}", message);
    }
}
