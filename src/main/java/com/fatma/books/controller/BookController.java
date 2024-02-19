package com.fatma.books.controller;

import com.fatma.books.model.dto.BookRequset;
import com.fatma.books.model.entity.Book;
import com.fatma.books.model.entity.Category;
import com.fatma.books.service.BookCategoryService;
import com.fatma.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@CrossOrigin("*")
public class BookController {
    @Autowired
    private BookCategoryService bookCategoryService;
    @Autowired
    private BookService bookService;
    @PostMapping("/assignBookToCategory")
    public ResponseEntity<?> assignBookToCategory(@RequestBody BookRequset bookDto)throws IOException {
        return bookCategoryService.assignBookToCategory(bookDto);
    }
    @PutMapping("/updateBook")
    public ResponseEntity<?> updateBook(@RequestBody BookRequset bookDto){
return bookCategoryService.updateBook(bookDto);
    }
    @GetMapping("/getBookById/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.getBookById(id);

    }
    @GetMapping("/getAllBooks")
    public ResponseEntity<?> getAllBooks(){
        return bookService.getAllBooks();
    }
    @DeleteMapping("/deleteBookById/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable int id){
        return bookService.deleteBookById(id);}
    @DeleteMapping("/deleteAllBooks")
    public ResponseEntity<?> deleteAllBooks(){
        return bookService.deleteAllBooks();

    }
    @GetMapping("/getBookByName")
    public Optional<Book> findBookByName(@RequestParam String bookName){
        return bookCategoryService.findBookByName(bookName);
    }

    }
