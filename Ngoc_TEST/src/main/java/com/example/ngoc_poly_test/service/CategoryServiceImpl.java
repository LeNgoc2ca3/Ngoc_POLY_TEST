package com.example.ngoc_poly_test.service;

import com.example.ngoc_poly_test.dto.CategoryDTO;
import com.example.ngoc_poly_test.entity.Category;
import com.example.ngoc_poly_test.repository.CategoryRepository;
import com.example.ngoc_poly_test.service.impl.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
   private CategoryRepository categoryRepository;

    @Autowired
   private ModelMapper mapper;
    @Override
    public List<CategoryDTO> getAllCategory() {
        List<Category> listCategory = categoryRepository.findAll();

        TypeToken<List<CategoryDTO>> typeToken = new TypeToken<>(){};

        List<CategoryDTO> listCategoryDTO = mapper.map(listCategory, typeToken.getType());

        return listCategoryDTO;
    }
}
