package com.learn.springcloud.sell.order.server.service;

import com.learn.springcloud.sell.order.server.dto.OrderDTO;

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
