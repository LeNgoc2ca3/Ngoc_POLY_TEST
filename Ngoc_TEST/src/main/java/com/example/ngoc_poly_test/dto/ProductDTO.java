package com.example.ngoc_poly_test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {


    private Long id;

    private String productName;

    private String color;

    private Long quantity;

    private Double sellPrice;

    private Double originPrice;

    private String description;

    private StatusDTO status;

    private Sub_CategoryDTO subCategory;

    private List<BrandDTO> brand;

}
