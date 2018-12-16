package com.learn.springcloud.sell.product.service;

import com.learn.springcloud.sell.product.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * @author yFoo
 * @date 16/12/2018
 */
public interface ProductCategoryService {

    /**
     * 通过类目编号查询商品类目
     * @param categoryTypes
     * @return
     */
    List<ProductCategory> findProductCategoriesByCategoryTypeIn(List<Integer> categoryTypes);
}
