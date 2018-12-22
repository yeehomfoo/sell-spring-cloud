package com.learn.springcloud.sell.order.server.enumeration;

import lombok.Getter;

/**
 * @author yFoo
 * @date 16/12/2018
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "参数错误"),
    CART_EMPTY(2, "购物车为空"),
    ;

    private Integer code;

    private String desc;

    ResultEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
