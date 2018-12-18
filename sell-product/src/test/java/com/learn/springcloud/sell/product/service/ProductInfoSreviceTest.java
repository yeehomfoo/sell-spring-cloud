package com.learn.springcloud.sell.product.service;

import com.learn.springcloud.sell.product.ProductApplicationTests;
import com.learn.springcloud.sell.product.dto.CartDTO;
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
        CartDTO cartDTO = new CartDTO("123457", 2);
        productInfoSrevice.decreaseStock(Arrays.asList(cartDTO));
    }
}