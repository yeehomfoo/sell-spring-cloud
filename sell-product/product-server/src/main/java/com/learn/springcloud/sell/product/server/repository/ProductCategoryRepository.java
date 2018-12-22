package com.learn.springcloud.sell.product.server.repository;

import com.learn.springcloud.sell.product.server.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author yFoo
 * @date 15/12/2018
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    List<ProductCategory> findProductCategoriesByCategoryTypeIn(List<Integer> categoryTypes);
}
