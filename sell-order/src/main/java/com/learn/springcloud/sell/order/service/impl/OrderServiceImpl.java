package com.learn.springcloud.sell.order.service.impl;

import com.learn.springcloud.sell.order.dataobject.OrderMaster;
import com.learn.springcloud.sell.order.dto.OrderDTO;
import com.learn.springcloud.sell.order.enumeration.OrderStatusEnum;
import com.learn.springcloud.sell.order.enumeration.PayStatusEnum;
import com.learn.springcloud.sell.order.repository.OrderDetailRepository;
import com.learn.springcloud.sell.order.repository.OrderMasterRepository;
import com.learn.springcloud.sell.order.service.OrderService;
import com.learn.springcloud.sell.order.util.KeyUtil;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author yFoo
 * @date 16/12/2018
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMasterRepository orderMasterRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {


        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderAmount(new BigDecimal(5));

        orderMasterRepository.save(orderMaster);

        return orderDTO;
    }
}
