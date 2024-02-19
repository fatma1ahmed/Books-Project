package com.fatma.books.controller;

import com.fatma.books.model.dto.CategoryDto;
import com.fatma.books.service.CategoryService;
import com.fatma.books.service.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/addCategory")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.addCategory(categoryDto);
    }
    @PutMapping("/updateCategory")
    public ResponseEntity<?> updateCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.updateCategory(categoryDto);
    }
    @GetMapping("/getCategoryById/{id}")
    public CategoryDto getCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }
    @GetMapping("/getAllCategories")
    public ResponseEntity<?> getAllCategories(){
        return categoryService.getAllCategories();
    }
    @DeleteMapping("/deleteCategoryById/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable int id){
        return categoryService.deleteCategoryById(id);
    }
    @DeleteMapping("/deleteAllCategories")
    public ResponseEntity<?> deleteAllCategories(){
        return categoryService.deleteAllCategories();
    }
}
