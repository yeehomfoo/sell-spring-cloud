package com.learn.springcloud.sell.order.util;

import com.learn.springcloud.sell.order.vo.ResultVO;
import lombok.var;

/**
 * @author yFoo
 * @date 16/12/2018
 */
public class ResultVOUtil {

    public static <T> ResultVO<T> success(T data) {
        var resultVO = new ResultVO<T>();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);

        return resultVO;
    }
}
