package com.learn.springcloud.sell.order.server.vo;

import lombok.Data;

/**
 * @author yFoo
 * @date 16/12/2018
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
