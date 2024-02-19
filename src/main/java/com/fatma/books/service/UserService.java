package com.fatma.books.service;

import com.fatma.books.model.entity.User;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.Optional;

public interface UserService {
    public ResponseEntity<?> register(User user) throws IOException;
    public  User login(String email,String password);
    public Optional<User> findByEmail(String email);
    public User getUserById(int id);
    public User checkUserIfExistOrThrowException(int id);
}
