package com.learn.springcloud.sell.order.server.message;

import com.learn.springcloud.sell.order.server.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author yFoo
 * @date 2018-12-28
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

//    @StreamListener(StreamClient.INPUT)
//    public void process(String payload) {
//        log.info("StreamReceiver: " +  payload);
//    }

    /**
     * 接收orderDTO对象消息
     * @param payload
     * @return
     */
    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.RETURN)
    public String process(OrderDTO payload) {
        log.info("StreamReceiver: " + payload);
        // 发送MQ返回消息
        return "received...";
    }

    @StreamListener(StreamClient.RETURN)
    public void processRetrun(String payload) {
        log.info("StreamReceiver return: " + payload);
    }
}
