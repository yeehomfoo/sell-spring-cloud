package com.learn.springcloud.sell.order.server.Exception;

import com.learn.springcloud.sell.order.server.enumeration.ResultEnum;
import lombok.Getter;

/**
 * @author yFoo
 * @date 16/12/2018
 */
@Getter
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getDesc());
        this.code = resultEnum.getCode();
    }
}
