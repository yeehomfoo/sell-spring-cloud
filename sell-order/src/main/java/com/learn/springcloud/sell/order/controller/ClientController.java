package com.learn.springcloud.sell.order.controller;

import com.learn.springcloud.sell.order.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yFoo
 * @date 16/12/2018
 */
@RestController
@Slf4j
public class ClientController {

//    @Autowired
//    LoadBalancerClient loadBalancerClient;

//    @Autowired
//    RestTemplate restTemplate;

    @Autowired
    ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        // 第一种方法：直接用RestTemplate调用写死的URL，不适用于不知道IP或有多个IP的场景
//        RestTemplate restTemplate = new RestTemplate();
//        var response = restTemplate.getForObject("http://localhost:8080/msg", String.class);

        // 第二种方法：用loadBalancerClient通过应用名获取到URL，再通过RestTemplate调用
//        ServiceInstance serviceInstance = loadBalancerClient.choose("SELL-PRODUCT");
//        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/msg";
//        RestTemplate restTemplate = new RestTemplate();
//        var response = restTemplate.getForObject(url, String.class);

        // 第三种方法：利用@LoadBalanced增强RestTemplate后，RestTemplate可直接通过应用名（serviceId）调用接口
//        var response = restTemplate.getForObject("http://SELL-PRODUCT/msg", String.class);

        String response = productClient.productMsg();
        log.info("response={}", response);
        return response;
    }
}
