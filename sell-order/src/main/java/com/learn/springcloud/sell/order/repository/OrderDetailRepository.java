package com.learn.springcloud.sell.order.repository;

import com.learn.springcloud.sell.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yFoo
 * @date 16/12/2018
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
