package com.learn.springcloud.sell.product.util;

import com.learn.springcloud.sell.product.vo.ResultVO;
import lombok.var;

import java.util.List;

/**
 * @author yFoo
 * @date 16/12/2018
 */
public class ResultVOUtil {

    public static <T> ResultVO<T> success(T data) {
        var result = new ResultVO<T>();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(data);
        return result;
    }
}
