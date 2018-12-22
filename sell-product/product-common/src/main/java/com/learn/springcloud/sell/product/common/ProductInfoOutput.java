package com.learn.springcloud.sell.product.common;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yFoo
 * @date 2018-12-22
 */
@Data
public class ProductInfoOutput {

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus;

    private Integer categoryType;
}
