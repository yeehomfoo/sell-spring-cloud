package com.learn.springcloud.sell.product.service.impl;

import com.learn.springcloud.sell.product.dataobject.ProductCategory;
import com.learn.springcloud.sell.product.repository.ProductCategoryRepository;
import com.learn.springcloud.sell.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yFoo
 * @date 16/12/2018
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findProductCategoriesByCategoryTypeIn(List<Integer> categoryTypes) {
        return productCategoryRepository.findProductCategoriesByCategoryTypeIn(categoryTypes);
    }
}
