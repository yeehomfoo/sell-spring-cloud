package com.learn.springcloud.sell.order.enumeration;

import lombok.Getter;

/**
 * @author yFoo
 * @date 16/12/2018
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "订单完结"),
    CANCELLED(2, "订单取消"),
    ;

    private Integer code;

    private String desc;

    OrderStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
