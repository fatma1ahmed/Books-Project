package com.fatma.books.controller;

import com.fatma.books.model.entity.Author;
import com.fatma.books.service.AuthorService;
import com.fatma.books.service.AuthorServiceImp;
import com.fatma.books.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
@CrossOrigin("*")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

@PostMapping("/addAuthor")
    public ResponseEntity<?> addAuthor(@RequestBody Author author) throws IOException {

    return authorService.addAuthor(author);
    }

    @PostMapping("/login")
    public Author login(@RequestParam String email,@RequestParam String password){
    return authorService.login(email,password);
    }
}
