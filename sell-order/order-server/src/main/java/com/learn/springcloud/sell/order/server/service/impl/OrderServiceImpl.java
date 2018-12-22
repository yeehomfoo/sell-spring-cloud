package com.learn.springcloud.sell.order.server.service.impl;

import com.learn.springcloud.sell.order.server.dto.OrderDetailDTO;
import com.learn.springcloud.sell.order.server.dataobject.OrderDetail;
import com.learn.springcloud.sell.order.server.dataobject.OrderMaster;
import com.learn.springcloud.sell.order.server.dto.OrderDTO;
import com.learn.springcloud.sell.order.server.enumeration.OrderStatusEnum;
import com.learn.springcloud.sell.order.server.enumeration.PayStatusEnum;
import com.learn.springcloud.sell.order.server.repository.OrderDetailRepository;
import com.learn.springcloud.sell.order.server.repository.OrderMasterRepository;
import com.learn.springcloud.sell.order.server.service.OrderService;
import com.learn.springcloud.sell.order.server.util.KeyUtil;
import com.learn.springcloud.sell.product.client.ProductClient;
import com.learn.springcloud.sell.product.common.DecreaseStockInput;
import com.learn.springcloud.sell.product.common.ProductInfoOutput;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
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
                .map(OrderDetailDTO::getProductId)
                .collect(Collectors.toList());
        var productInfoOutputList = productClient.listForOrder(productIdList);

        // 计算总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        String orderId = KeyUtil.genUniqueKey();
        List<OrderDetail> orderDetailList = orderDTO.getOrderDetailList().stream()
                .map(orderDetailDTO -> {
                    var orderDetail = new OrderDetail();
                    BeanUtils.copyProperties(orderDetailDTO, orderDetail);
                    return orderDetail;
                })
                .collect(Collectors.toList());
        for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
            for (OrderDetail orderDetail : orderDetailList) {
                if (orderDetail.getProductId().equals(productInfoOutput.getProductId())) {
                    orderAmount = productInfoOutput.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);

                    // 订单详情入库
                    BeanUtils.copyProperties(productInfoOutput, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    orderDetailRepository.save(orderDetail);
                }
            }
        }

        // 扣库存
        var decreaseStockInputList = orderDTO.getOrderDetailList().stream()
                .map(orderDetail -> new DecreaseStockInput(orderDetail.getProductId(), orderDetail.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(decreaseStockInputList);

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
