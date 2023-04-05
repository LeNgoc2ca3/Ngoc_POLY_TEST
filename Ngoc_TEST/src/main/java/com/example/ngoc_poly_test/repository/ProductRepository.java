package com.example.ngoc_poly_test.repository;

import com.example.ngoc_poly_test.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM product_brand a WHERE a.product_id =:idProduct", nativeQuery = true)
    void deleteProductBrand(@Param("idProduct") Long idProduct);


}
