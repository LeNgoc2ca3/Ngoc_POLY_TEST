package com.example.ngoc_poly_test.service;

import com.example.ngoc_poly_test.dto.ProductDTO;
import com.example.ngoc_poly_test.entity.Product;
import com.example.ngoc_poly_test.repository.ProductRepository;
import com.example.ngoc_poly_test.service.impl.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<ProductDTO> getAllProduct() {
        List<Product> listProduct = productRepository.findAll();
        TypeToken<List<ProductDTO>> typeToken = new TypeToken<>() {
        };
        List<ProductDTO> listProductDTO = mapper.map(listProduct, typeToken.getType());

        return listProductDTO;
    }

    @Override
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id).get();
        ProductDTO productDTO = mapper.map(product,ProductDTO.class);
        return productDTO;
    }

    @Override
    public Boolean existsById(Long id) {
        if(!productRepository.existsById(id)){
            return false;
        }
        return true;
    }

    @Override
    public ProductDTO saveOrUpdate(ProductDTO productDTO) {
        Product product = mapper.map(productDTO,Product.class);

        Product productSave = productRepository.save(product);

        mapper.map(productSave,productDTO);

        return productDTO;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteProductBrand(id);
        productRepository.deleteById(id);
    }
}
