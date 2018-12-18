package com.learn.springcloud.sell.product.repository;

import com.learn.springcloud.sell.product.dataobject.ProductInfo;
import lombok.var;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yFoo
 * @date 15/12/2018
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Test
    public void findProductInfosByProductStatus() {
        List<ProductInfo> productInfos = productInfoRepository.findProductInfosByProductStatus(0);
        Assert.assertTrue(productInfos.size() > 0);
    }

    @Test
    public void findProductInfosByProductIdIn() {
        var productInfoList = productInfoRepository.findProductInfosByProductIdIn(Arrays.asList("123457", "1542474133963997924"));
        Assert.assertTrue(productInfoList.size() > 0);
    }
}