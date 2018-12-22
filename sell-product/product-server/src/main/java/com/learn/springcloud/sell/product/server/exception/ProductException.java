package com.learn.springcloud.sell.product.server.exception;

import com.learn.springcloud.sell.product.server.enumeration.ResultEnum;

/**
 * @author yFoo
 * @date 19/12/2018
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getDesc());
        this.code = resultEnum.getCode();
    }
}
