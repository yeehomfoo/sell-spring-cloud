package com.learn.springcloud.sell.order.service;

import com.learn.springcloud.sell.order.dto.OrderDTO;

/**
 * @author yFoo
 * @date 16/12/2018
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
