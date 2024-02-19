package com.fatma.books.service;

import com.fatma.books.model.entity.Author;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface AuthorService {
    public ResponseEntity<?> addAuthor(Author author) throws IOException;
    public Author login(String email, String password);
    public Author getAuthorById(int id);

}
