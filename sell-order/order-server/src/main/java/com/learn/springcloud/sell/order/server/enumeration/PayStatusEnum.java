package com.learn.springcloud.sell.order.server.enumeration;

import lombok.Getter;

/**
 * @author yFoo
 * @date 16/12/2018
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;

    private String desc;

    PayStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
