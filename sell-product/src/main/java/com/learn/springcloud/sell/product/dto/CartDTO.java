package com.learn.springcloud.sell.product.dto;

import lombok.Data;

/**
 * @author yFoo
 * @date 19/12/2018
 */
@Data
public class CartDTO {

    private String productId;

    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
