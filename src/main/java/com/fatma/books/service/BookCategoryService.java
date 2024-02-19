package com.fatma.books.service;

import com.fatma.books.model.dto.BookRequset;
import com.fatma.books.model.entity.Book;
import com.fatma.books.model.entity.Category;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Optional;

public interface BookCategoryService {
    public ResponseEntity<?> assignBookToCategory(BookRequset bookDto) throws IOException;
    public Optional<Book> findBookByName(String bookName);
    public ResponseEntity<?> updateBook(BookRequset bookDto);
public ResponseEntity<?> deleteBook(int categoryId);

}
