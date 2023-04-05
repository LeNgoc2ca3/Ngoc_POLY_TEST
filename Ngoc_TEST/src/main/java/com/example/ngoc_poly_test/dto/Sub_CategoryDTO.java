package com.example.ngoc_poly_test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Sub_CategoryDTO {
    private Long id;

    private String subCategoryCode;

    private String subCategoryName;

    private CategoryDTO category;
}
