package com.fatma.books.service;

import com.fatma.books.exception.RecordNotFoundException;
import com.fatma.books.model.dto.CategoryDto;
import com.fatma.books.model.entity.Category;
import com.fatma.books.repositry.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CategoryServiceImp implements CategoryService{
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public ResponseEntity<?> addCategory(CategoryDto categoryDto) {

        return new ResponseEntity<>(CategoryDto.fromEntityToDto(categoryRepo.save(Category.toEntity(categoryDto))),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateCategory(CategoryDto categoryDto) {
        checkCategoryIfExistOrThrowException(categoryDto.getId());

        return new ResponseEntity<>(CategoryDto.fromEntityToDto(categoryRepo.save(Category.toEntity(categoryDto))),HttpStatus.OK);
    }

    @Override
    public CategoryDto getCategoryById(int id) {
      CategoryDto categoryDto = CategoryDto.fromEntityToDto(categoryRepo.findById(id).orElseThrow(
              ()->new RecordNotFoundException("this category with " + id + " not found")
         ));
      return categoryDto;
    }

    @Override
    public ResponseEntity<?> getAllCategories() {
        List<Category> categoryList=categoryRepo.findAll();
        if(!categoryList.isEmpty() &&categoryList != null){
            return new ResponseEntity<>(categoryList,HttpStatus.FOUND);
        }
        throw new RecordNotFoundException("this Records not found");


    }

    @Override
    public ResponseEntity<?> deleteCategoryById(int id) {
        checkCategoryIfExistOrThrowException(id);
        categoryRepo.deleteById(id);
        return new ResponseEntity<>("category has been successfully deleted ",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteAllCategories() {
        categoryRepo.deleteAll();
        return new ResponseEntity<>("All categories have been successfully deleted ",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> checkCategoryIfExistOrThrowException(int id) {
       return new ResponseEntity<>(getCategoryById(id),HttpStatus.FOUND);

    }
}
