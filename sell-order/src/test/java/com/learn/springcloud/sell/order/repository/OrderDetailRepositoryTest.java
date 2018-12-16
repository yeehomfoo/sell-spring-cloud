package com.learn.springcloud.sell.order.repository;

import com.learn.springcloud.sell.order.OrderApplicationTests;
import com.learn.springcloud.sell.order.dataobject.OrderDetail;
import lombok.var;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author yFoo
 * @date 16/12/2018
 */
public class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    @Transactional
    public void save() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("detailId");
        orderDetail.setOrderId("orderId");
        orderDetail.setProductIcon("productIcon");
        orderDetail.setProductName("productName");
        orderDetail.setProductId("productId");
        orderDetail.setProductPrice(new BigDecimal("2.5"));
        orderDetail.setProductQuantity(2);
        var result = orderDetailRepository.save(orderDetail);
        Assert.assertTrue(result != null);
    }
}