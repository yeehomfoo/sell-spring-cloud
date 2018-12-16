package com.learn.springcloud.sell.product.repository;

import com.learn.springcloud.sell.product.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yFoo
 * @date 15/12/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Test
    public void findProductCategoriesByCategoryTypeIn() {
        List<ProductCategory> productCategories = productCategoryRepository.findProductCategoriesByCategoryTypeIn(Arrays.asList(101, 102));
        Assert.assertTrue(productCategories.size() > 0);
    }
}