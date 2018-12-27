package com.learn.springcloud.sell.order.server.controller;

import com.learn.springcloud.sell.order.server.dto.OrderDTO;
import com.learn.springcloud.sell.order.server.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author yFoo
 * @date 2018-12-28
 */
@RestController
public class StreamController {

    @Autowired
    StreamClient streamClient;

//    @GetMapping("/sendMessage")
//    public void send() {
//        String message = "now: " + new Date();
//        streamClient.output().send(MessageBuilder.withPayload(message).build());
//    }

    @GetMapping("/sendMessage")
    public void send() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("xxxx");
        streamClient.output().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
