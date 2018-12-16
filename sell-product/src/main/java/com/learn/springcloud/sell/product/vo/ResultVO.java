package com.learn.springcloud.sell.product.vo;

import lombok.Data;

/**
 * HTTP 请求返回的最外层对象
 * @author yFoo
 * @date 16/12/2018
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
