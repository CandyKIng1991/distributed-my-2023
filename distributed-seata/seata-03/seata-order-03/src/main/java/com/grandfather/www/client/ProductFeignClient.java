package com.grandfather.www.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author MrLiu
 */
@FeignClient(name = "seata-product", url = "http://localhost:8086")
public interface ProductFeignClient {

    @GetMapping("/deduct")
    Boolean deduct(@RequestParam Long productId,
                   @RequestParam Integer count);
}
