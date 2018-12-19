package com.learn.springcloud.sell.order.service.impl;

import com.learn.springcloud.sell.order.client.ProductClient;
import com.learn.springcloud.sell.order.dataobject.OrderDetail;
import com.learn.springcloud.sell.order.dataobject.OrderMaster;
import com.learn.springcloud.sell.order.dataobject.ProductInfo;
import com.learn.springcloud.sell.order.dto.CartDTO;
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
import java.math.BigInteger;
import java.util.stream.Collectors;

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

    @Autowired
    ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        // 查询商品信息
        var productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        var productInfoList = productClient.listForOrder(productIdList);

        // 计算总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        String orderId = KeyUtil.genUniqueKey();
        for (ProductInfo productInfo : productInfoList) {
            for (OrderDetail orderDetail : orderDTO.getOrderDetailList()) {
                if (orderDetail.getProductId().equals(productInfo.getProductId())) {
                    orderAmount = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);

                    // 订单详情入库
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    orderDetailRepository.save(orderDetail);
                }
            }
        }

        // 扣库存
        var cartDTOList = orderDTO.getOrderDetailList().stream()
                .map(orderDetail -> new CartDTO(orderDetail.getProductId(), orderDetail.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);

        // 订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderAmount(orderAmount);
        orderMasterRepository.save(orderMaster);

        return orderDTO;
    }
}
