package com.learn.springcloud.sell.product.enumeration;

import lombok.Getter;

/**
 * @author yFoo
 * @date 16/12/2018
 */
@Getter
public enum ProductStatusEnum {
    /**
     * 商品在架
     */
    UP(0, "在架"),
    /**
     * 商品下架
     */
    DOWN(1, "下架")
    ;

    private Integer code;

    private String desc;

    ProductStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
