package com.learn.springcloud.sell.product.server.service;

import com.learn.springcloud.sell.product.server.ProductApplicationTests;
import lombok.var;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author yFoo
 * @date 16/12/2018
 */
@Component
public class ProductCategoryServiceTest extends ProductApplicationTests {

    @Autowired
    ProductCategoryService productCategoryService;

    @Test
    public void findProductCategoriesByCategoryTypeIn() {
        var productCategories = productCategoryService.findProductCategoriesByCategoryTypeIn(Arrays.asList(101, 102));
        Assert.assertTrue(productCategories.size() > 0);
    }
}