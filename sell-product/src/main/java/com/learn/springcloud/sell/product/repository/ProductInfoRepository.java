package com.learn.springcloud.sell.product.repository;

import com.learn.springcloud.sell.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yFoo
 * @date 15/12/2018
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findProductInfosByProductStatus(Integer productStatus);

    List<ProductInfo> findProductInfosByProductIdIn(List<String> productIdList);
}
