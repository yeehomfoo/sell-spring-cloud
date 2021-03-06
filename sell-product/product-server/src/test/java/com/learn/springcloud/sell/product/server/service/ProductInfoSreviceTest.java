package com.learn.springcloud.sell.product.server.service;

import com.learn.springcloud.sell.product.common.DecreaseStockInput;
import com.learn.springcloud.sell.product.server.ProductApplicationTests;
import lombok.var;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

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

    @Test
    public void findProductInfos() {
        var productInfos = productInfoSrevice.findList(Arrays.asList("123457", "1542474133963997924"));
        Assert.assertTrue(productInfos.size() > 0);
    }

    @Test
    public void decreaseStock() {
        var productInfoInput = new DecreaseStockInput("123457", 2);
        productInfoSrevice.decreaseStock(Arrays.asList(productInfoInput));
    }
}