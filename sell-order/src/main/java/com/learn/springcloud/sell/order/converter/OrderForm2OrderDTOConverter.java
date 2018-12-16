package com.learn.springcloud.sell.order.converter;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.learn.springcloud.sell.order.Exception.OrderException;
import com.learn.springcloud.sell.order.dataobject.OrderDetail;
import com.learn.springcloud.sell.order.dto.OrderDTO;
import com.learn.springcloud.sell.order.enumeration.ResultEnum;
import com.learn.springcloud.sell.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import lombok.var;

import java.util.List;

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

        List<OrderDetail> orderDetailList = null;
        Gson gson = new Gson();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {}.getType());
        } catch (JsonSyntaxException e) {
            log.error("【json转换】错误，string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
