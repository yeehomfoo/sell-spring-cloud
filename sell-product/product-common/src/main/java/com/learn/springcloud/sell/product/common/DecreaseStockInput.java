package com.learn.springcloud.sell.product.common;

import lombok.Data;

/**
 * 减库存入参
 * @author yFoo
 * @date 2018-12-22
 */
@Data
public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
