package com.learn.springcloud.sell.order.server.controller;

import com.learn.springcloud.sell.order.server.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yFoo
 * @date 2018-12-25
 */
@RestController
public class GirlController {

    @Autowired
    GirlConfig girlConfig;

    @GetMapping("/girl/print")
    public String print() {
        return girlConfig.toString();
    }
}
