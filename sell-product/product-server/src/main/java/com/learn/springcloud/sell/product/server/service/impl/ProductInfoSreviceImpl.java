package com.learn.springcloud.sell.product.server.service.impl;

import com.learn.springcloud.sell.product.common.DecreaseStockInput;
import com.learn.springcloud.sell.product.server.dataobject.ProductInfo;
import com.learn.springcloud.sell.product.server.enumeration.ProductStatusEnum;
import com.learn.springcloud.sell.product.server.enumeration.ResultEnum;
import com.learn.springcloud.sell.product.server.exception.ProductException;
import com.learn.springcloud.sell.product.server.repository.ProductInfoRepository;
import com.learn.springcloud.sell.product.server.service.ProductInfoSrevice;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        decreaseStockInputList.stream()
                .forEach(productInfoInput -> {
                    // 判断商品是否存在
                    var productInfoOptional = productInfoRepository.findById(productInfoInput.getProductId());
                    if (!productInfoOptional.isPresent()) {
                        throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
                    }

                    // 库存是否足够
                    var productInfo = productInfoOptional.get();
                    Integer result = productInfo.getProductStock() - productInfoInput.getProductQuantity();
                    if (result < 0) {
                        throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
                    }
                    productInfo.setProductStock(result);
                    productInfoRepository.save(productInfo);
                });
    }
}
