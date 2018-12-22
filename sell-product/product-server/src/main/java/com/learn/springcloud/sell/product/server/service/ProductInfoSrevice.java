package com.learn.springcloud.sell.product.server.service;

import com.learn.springcloud.sell.product.common.DecreaseStockInput;
import com.learn.springcloud.sell.product.server.dataobject.ProductInfo;

import java.util.List;

/**
 * 商品
 * @author yFoo
 * @date 16/12/2018
 */
public interface ProductInfoSrevice {

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
