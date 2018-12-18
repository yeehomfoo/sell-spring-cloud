package com.learn.springcloud.sell.product.service.impl;

import com.learn.springcloud.sell.product.dataobject.ProductInfo;
import com.learn.springcloud.sell.product.enumeration.ProductStatusEnum;
import com.learn.springcloud.sell.product.repository.ProductInfoRepository;
import com.learn.springcloud.sell.product.service.ProductInfoSrevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yFoo
 * @date 16/12/2018
 */
@Service
public class ProductInfoSreviceImpl implements ProductInfoSrevice {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findProductInfosByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findProductInfosByProductIdIn(productIdList);
    }
}
