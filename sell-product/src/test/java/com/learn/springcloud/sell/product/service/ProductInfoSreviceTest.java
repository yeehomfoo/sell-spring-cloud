package com.learn.springcloud.sell.product.service;

import com.learn.springcloud.sell.product.ProductApplicationTests;
import lombok.var;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

/**
 * @author yFoo
 * @date 16/12/2018
 */
public class ProductInfoSreviceTest extends ProductApplicationTests {

    @Autowired
    ProductInfoSrevice productInfoSrevice;

    @Test
    public void findUpAll() {
        var productInfos = productInfoSrevice.findUpAll();
        Assert.assertTrue(productInfos.size() > 0);
    }
}