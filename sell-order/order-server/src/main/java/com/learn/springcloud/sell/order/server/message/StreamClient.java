package com.learn.springcloud.sell.order.server.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author yFoo
 * @date 2018-12-28
 */

public interface StreamClient {

    String INPUT = "myInput";
    String RETURN = "myReturn";
    String OUTPUT = "myOutput";

    @Input(StreamClient.INPUT)
    SubscribableChannel input();

    @Input(StreamClient.RETURN)
    SubscribableChannel returnInput();

    @Output(StreamClient.OUTPUT)
    MessageChannel output();
}
