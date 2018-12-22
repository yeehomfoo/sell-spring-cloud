package com.learn.springcloud.sell.product.server.enumeration;

import lombok.Getter;

/**
 * @author yFoo
 * @date 19/12/2018
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(1, "商品不存在"),
    PRODUCT_STOCK_ERROR(2, "库存有误")
    ;

    private Integer code;

    private String desc;

    ResultEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
