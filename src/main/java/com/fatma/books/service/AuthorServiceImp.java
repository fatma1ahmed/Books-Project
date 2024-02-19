package com.fatma.books.service;

import com.fatma.books.exception.RecordNotCorrectException;
import com.fatma.books.exception.RecordNotFoundException;
import com.fatma.books.model.entity.Author;
import com.fatma.books.repositry.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AuthorServiceImp implements AuthorService{
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private ImageService imageService;
    @Override
    public ResponseEntity<?> addAuthor(Author author) throws IOException {

   byte[] imageByte=imageService.decodeBase64(author.getImagePath());
        author.setImagePath(imageService.saveImage(imageByte));
      return new ResponseEntity<>(authorRepo.save(author), HttpStatus.CREATED);
    }

    @Override
    public Author login(String email, String password) {
      Author author= authorRepo.login(email, password).orElseThrow(
              ()->new RecordNotCorrectException("email or password not correct")
        );
        return author;
    }

    @Override
    public Author getAuthorById(int id) {
        Author author=authorRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("Author with " + id + " not found")
        );
        return author;
    }

}
