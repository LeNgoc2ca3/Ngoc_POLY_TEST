package com.example.ngoc_poly_test.controller;

import com.example.ngoc_poly_test.dto.ProductDTO;
import com.example.ngoc_poly_test.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = {"http://localhost:8080","http://127.0.0.1:5500"})
@CrossOrigin("*")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<ProductDTO> listProductDTO = productService.getAllProduct();
        return ResponseEntity.ok(listProductDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable("id") Long id) {
        if (!productService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        ProductDTO productDTO = productService.findById(id);
        return ResponseEntity.ok(productDTO);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> post(@RequestBody ProductDTO productDTO) {
        if (productService.existsById(productDTO.getId())) {
            return ResponseEntity.badRequest().build();
        }
        productService.saveOrUpdate(productDTO);
        return ResponseEntity.ok(productDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> put (@PathVariable("id") Long id , @RequestBody ProductDTO productDTO){
        if(!productService.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        productService.saveOrUpdate(productDTO);
        return ResponseEntity.ok(productDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        if(!productService.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        productService.delete(id);
        return ResponseEntity.ok().build();
    }

}
