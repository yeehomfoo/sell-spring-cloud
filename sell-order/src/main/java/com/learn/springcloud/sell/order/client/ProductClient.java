package com.learn.springcloud.sell.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author yFoo
 * @date 17/12/2018
 */
@FeignClient(name = "sell-product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();
}
