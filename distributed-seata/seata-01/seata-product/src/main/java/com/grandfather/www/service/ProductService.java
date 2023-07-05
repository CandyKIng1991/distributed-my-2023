package com.grandfather.www.service;

import com.grandfather.www.dao.ProductDao;
import com.grandfather.www.pojo.ProductEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public void deduct(Long productId, Integer count) {
        log.info("开始扣库存. productId={}, count={}", productId, count);
        // 找到这个数据
        Optional<ProductEntity> byId = productDao.findById(productId);

        // 数据存在不为空
        if (byId.isPresent()) {
            ProductEntity entity = byId.get();
            //库存减去了
            entity.setCount(entity.getCount() - count);
            // 减完结果保存
            productDao.save(entity);
        }
    }
}
