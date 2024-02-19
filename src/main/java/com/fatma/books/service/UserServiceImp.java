package com.fatma.books.service;

import com.fatma.books.exception.DuplicateRecordException;
import com.fatma.books.exception.RecordNotCorrectException;
import com.fatma.books.exception.RecordNotFoundException;
import com.fatma.books.model.entity.Author;
import com.fatma.books.model.entity.Star;
import com.fatma.books.model.entity.User;
import com.fatma.books.repositry.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
@Service

public class UserServiceImp implements UserService{
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ImageService imageService;
    @Override
    public ResponseEntity<?> register(User user) throws IOException {
     byte[] imageByte=imageService.decodeBase64(user.getImagePath());
     user.setImagePath(imageService.saveImage(imageByte));

        Optional<User> user1=findByEmail(user.getEmail());
        if(user1.isPresent()){
            throw new DuplicateRecordException("this email with anther user ");
        }
        return new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);
    }

    @Override
    public User login(String email, String password) {
        User user=userRepo.login(email, password).orElseThrow(
                ()->new RecordNotCorrectException("email or password not correct")
        );
        return user;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public User getUserById(int id) {
        User user=userRepo.findById(id).orElseThrow(
                ()->new RecordNotFoundException("star with " + id + " not found")

        );
        return user;
    }

    @Override
    public User checkUserIfExistOrThrowException(int id) {
        return getUserById(id);
    }
}
