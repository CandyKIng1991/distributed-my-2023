package com.grandfather.www.dao;

import com.grandfather.www.pojo.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MrLiu
 */
public interface ProductDao extends JpaRepository<ProductEntity, Long> {
}
