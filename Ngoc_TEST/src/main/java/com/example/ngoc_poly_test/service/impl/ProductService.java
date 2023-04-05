package com.example.ngoc_poly_test.service.impl;

import com.example.ngoc_poly_test.dto.ProductDTO;
import com.example.ngoc_poly_test.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProduct();

    ProductDTO findById(Long id);

    Boolean existsById(Long id);

    ProductDTO saveOrUpdate(ProductDTO productDTO);

    void delete(Long id);
}
