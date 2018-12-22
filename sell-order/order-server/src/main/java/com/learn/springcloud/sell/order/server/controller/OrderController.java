package com.learn.springcloud.sell.order.server.controller;

import com.learn.springcloud.sell.order.server.Exception.OrderException;
import com.learn.springcloud.sell.order.server.converter.OrderForm2OrderDTOConverter;
import com.learn.springcloud.sell.order.server.enumeration.ResultEnum;
import com.learn.springcloud.sell.order.server.form.OrderForm;
import com.learn.springcloud.sell.order.server.vo.ResultVO;
import com.learn.springcloud.sell.order.server.service.OrderService;
import com.learn.springcloud.sell.order.server.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yFoo
 * @date 16/12/2018
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确，orderForm: {}", orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        var orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            throw new OrderException(ResultEnum.CART_EMPTY);
        }

        orderDTO = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", orderDTO.getOrderId());

        return ResultVOUtil.success(map);
    }
}
