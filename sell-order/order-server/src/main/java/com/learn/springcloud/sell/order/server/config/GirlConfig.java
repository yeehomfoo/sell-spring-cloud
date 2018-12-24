package com.learn.springcloud.sell.order.server.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author yFoo
 * @date 2018-12-25
 */
@Component
@ConfigurationProperties("girl")
@RefreshScope
@Data
public class GirlConfig {

    private String name;

    private String age;
}
