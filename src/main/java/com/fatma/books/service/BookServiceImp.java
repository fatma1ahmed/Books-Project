package com.fatma.books.service;

import com.fatma.books.exception.RecordNotFoundException;
import com.fatma.books.model.entity.Book;
import com.fatma.books.repositry.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service

public class BookServiceImp implements BookService{
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private AuthorService authorService;
@Autowired
private  CategoryService categoryService;
    @Override
    public ResponseEntity<?> addBook(Book book) {

        return new ResponseEntity<>(bookRepo.save(book),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateBook(Book book){

        return new ResponseEntity<>(bookRepo.save(book),HttpStatus.OK);
    }

    @Override
    public Book getBookById(int id) {
        return bookRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("book with " + id + " not found")
        );

    }

    @Override
    public ResponseEntity<?> getAllBooks() {
      List<Book> booList= bookRepo.findAll();
      if(!booList.isEmpty()&& booList!=null){
          return new ResponseEntity<>(booList,HttpStatus.FOUND) ;
      }
      throw new RecordNotFoundException("this Records not found");

    }

    @Override
    public ResponseEntity<?> deleteBookById(int id) {
        checkBookIfExistOrThrowException(id);
        bookRepo.deleteById(id);
        return new ResponseEntity<>("book has been successfully deleted",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteAllBooks() {
        bookRepo.deleteAll();
        return new ResponseEntity<>("All books have been successfully deleted",HttpStatus.OK);
    }

    @Override
    public Book checkBookIfExistOrThrowException(int id) {
       return getBookById(id);

      }


}
