package com.learn.springcloud.sell.order.server.repository;

import com.learn.springcloud.sell.order.server.OrderApplicationTests;
import com.learn.springcloud.sell.order.server.dataobject.OrderMaster;
import com.learn.springcloud.sell.order.server.enumeration.OrderStatusEnum;
import com.learn.springcloud.sell.order.server.enumeration.PayStatusEnum;
import lombok.var;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.math.BigDecimal;

/**
 * @author yFoo
 * @date 16/12/2018
 */
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Test
    @Transactional
    public void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerAddress("test");
        orderMaster.setBuyerName("test");
        orderMaster.setBuyerOpenid("test");
        orderMaster.setBuyerPhone("test");
        orderMaster.setOrderAmount(new BigDecimal("2.5"));
        orderMaster.setOrderId("orderId");
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        var result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result != null);
    }
}