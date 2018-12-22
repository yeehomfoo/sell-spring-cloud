package com.learn.springcloud.sell.order.server.converter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.learn.springcloud.sell.order.server.Exception.OrderException;
import com.learn.springcloud.sell.order.server.dto.OrderDetailDTO;
import com.learn.springcloud.sell.order.server.dataobject.OrderDetail;
import com.learn.springcloud.sell.order.server.dto.OrderDTO;
import com.learn.springcloud.sell.order.server.enumeration.ResultEnum;
import com.learn.springcloud.sell.order.server.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yFoo
 * @date 16/12/2018
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        var orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetailDTO> orderDetailDTOList = null;
        Gson gson = new Gson();
        try {
            List<OrderDetail> orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {}.getType());
            orderDetailDTOList = orderDetailList.stream()
                    .map(orderDetail -> {
                        var orderDetailDTO = new OrderDetailDTO();
                        BeanUtils.copyProperties(orderDetail, orderDetailDTO);
                        return orderDetailDTO;
                    }).collect(Collectors.toList());
        } catch (JsonSyntaxException e) {
            log.error("【json转换】错误，string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailDTOList);

        return orderDTO;
    }
}
