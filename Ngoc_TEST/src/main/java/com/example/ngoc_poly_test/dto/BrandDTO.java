package com.example.ngoc_poly_test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BrandDTO  {

    private Long id ;

    private String brandName;

    private List<ProductDTO> product;

}
