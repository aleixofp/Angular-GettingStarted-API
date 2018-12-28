package com.fpa.agsapipluralsight.data.product.repository;

import com.fpa.agsapipluralsight.data.product.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
