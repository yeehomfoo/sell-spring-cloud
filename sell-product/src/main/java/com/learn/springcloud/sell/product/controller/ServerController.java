package com.learn.springcloud.sell.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yFoo
 * @date 16/12/2018
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg() {
        return "this is product server";
    }
}
