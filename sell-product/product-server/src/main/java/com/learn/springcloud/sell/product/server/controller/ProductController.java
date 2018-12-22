package com.learn.springcloud.sell.product.server.controller;

import com.learn.springcloud.sell.product.common.DecreaseStockInput;
import com.learn.springcloud.sell.product.common.ProductInfoOutput;
import com.learn.springcloud.sell.product.server.dataobject.ProductInfo;
import com.learn.springcloud.sell.product.server.service.ProductCategoryService;
import com.learn.springcloud.sell.product.server.service.ProductInfoSrevice;
import com.learn.springcloud.sell.product.server.util.ResultVOUtil;
import com.learn.springcloud.sell.product.server.vo.ProductInfoVO;
import com.learn.springcloud.sell.product.server.vo.ProductVO;
import com.learn.springcloud.sell.product.server.vo.ResultVO;
import lombok.val;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yFoo
 * @date 15/12/2018
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductInfoSrevice productInfoSrevice;

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 获取商品列表
     */
    @GetMapping("/list")
    public ResultVO<List<ProductVO>> list() {
        // 1. 查询所有在架的商品
        var productInfoList = productInfoSrevice.findUpAll();

        // 2. 获取类目TYPE列表
        var categoryList = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        // 3. 查询类目
        val productCategoryList = productCategoryService
                .findProductCategoriesByCategoryTypeIn(categoryList);

        // 4. 构造数据
        List<ProductVO> productVOList = productCategoryList.stream()
                .map(productCategory -> {
                    List<ProductInfoVO> productInfoVOS = productInfoList.stream()
                            .filter(productInfo -> !productCategory.getCategoryType().equals(productInfo.getCategoryType()))
                            .map(productInfo -> {
                                var productInfoVO = new ProductInfoVO();
                                BeanUtils.copyProperties(productInfo, productInfoVO);
                                return productInfoVO;
                            })
                            .collect(Collectors.toList());
                    var productVO = new ProductVO();
                    BeanUtils.copyProperties(productCategory, productVO);
                    productVO.setProductInfoVOList(productInfoVOS);
                    return productVO;
                })
                .collect(Collectors.toList());

        return ResultVOUtil.success(productVOList);
    }

    /**
     * 获取商品列表（给订单服务用的）
     * @param productIdList
     * @return
     */
    @PostMapping("/listForOrder")
    public List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList) {
        var productInfoList = productInfoSrevice.findList(productIdList);
        return productInfoList.stream()
                .map(productInfo -> {
                    var productInfoOutput = new ProductInfoOutput();
                    BeanUtils.copyProperties(productInfo, productInfoOutput);
                   return productInfoOutput;
                })
                .collect(Collectors.toList());
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList) {
        productInfoSrevice.decreaseStock(decreaseStockInputList);
    }
}
