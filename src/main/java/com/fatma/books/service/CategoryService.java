package com.fatma.books.service;

import com.fatma.books.model.dto.CategoryDto;
import org.springframework.http.ResponseEntity;

public interface CategoryService {

    public ResponseEntity<?> addCategory(CategoryDto categoryDto);
    public ResponseEntity<?> updateCategory(CategoryDto categoryDto);
    public CategoryDto getCategoryById(int id);
    public ResponseEntity<?> getAllCategories();
    public ResponseEntity<?> deleteCategoryById(int id);
    public ResponseEntity<?> deleteAllCategories();
    public ResponseEntity<?> checkCategoryIfExistOrThrowException(int id);

}
