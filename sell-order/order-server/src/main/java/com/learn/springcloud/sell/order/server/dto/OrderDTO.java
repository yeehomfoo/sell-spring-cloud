package com.learn.springcloud.sell.order.server.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author yFoo
 * @date 16/12/2018
 */
@Data
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payStatus;

    private List<OrderDetailDTO> orderDetailList;

}
