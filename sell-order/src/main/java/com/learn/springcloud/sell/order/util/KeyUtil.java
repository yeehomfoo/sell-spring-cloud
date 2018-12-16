package com.learn.springcloud.sell.order.util;

import org.apache.commons.lang.StringUtils;

import java.util.Random;

/**
 * @author yFoo
 * @date 16/12/2018
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式：时间 + 随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        int randomInt = random.nextInt(900000) + 100000;
        return StringUtils.EMPTY + System.currentTimeMillis() + randomInt;
    }
}
