package com.fatma.books.controller;

import com.fatma.books.model.entity.User;
import com.fatma.books.service.UserService;
import com.fatma.books.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) throws IOException {
        return userService.register(user);
    }
    @PostMapping("/userLogin")
    public  User login(@RequestParam String email,@RequestParam String password){
        return userService.login(email, password);
    }
}
