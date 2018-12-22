package com.learn.springcloud.sell.order.server.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yFoo
 * @date 2018-12-22
 */
@Data
public class OrderDetailDTO {

    private String detailId;

    private String orderId;

    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productIcon;
}
