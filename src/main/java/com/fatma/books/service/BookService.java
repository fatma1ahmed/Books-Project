package com.fatma.books.service;


import com.fatma.books.model.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    public ResponseEntity<?> addBook(Book book);
    public ResponseEntity<?> updateBook(Book book);
    public Book getBookById(int id);
    public ResponseEntity<?> getAllBooks();
    public ResponseEntity<?> deleteBookById(int id);
    public ResponseEntity<?> deleteAllBooks();
    public Book checkBookIfExistOrThrowException(int id);


}
