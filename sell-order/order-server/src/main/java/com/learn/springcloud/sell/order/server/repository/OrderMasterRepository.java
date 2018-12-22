package com.learn.springcloud.sell.order.server.repository;

import com.learn.springcloud.sell.order.server.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yFoo
 * @date 16/12/2018
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
