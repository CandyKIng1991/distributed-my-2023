package com.grandfather.www.controller;

import com.grandfather.www.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 扣除库存
     *
     * <a href="http://localhost:8086/deduct?productId=5001&count=5">...</a>
     *
     * @param productId 产品ID
     * @param count     数量
     * @return 是否删除成功
     */
    @GetMapping("/deduct")
    public Boolean deduct(@RequestParam Long productId,
                          @RequestParam Integer count) {
        productService.deduct(productId, count);
        return true;
    }
}
