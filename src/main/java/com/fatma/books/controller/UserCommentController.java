package com.fatma.books.controller;

import com.fatma.books.service.UserCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@CrossOrigin("*")
public class UserCommentController {
    @Autowired
    private UserCommentService userCommentService;
    @PostMapping("/putComment/{userId}/{bookId}")
    public ResponseEntity<?> putComment(@PathVariable int bookId,@PathVariable int userId,@RequestParam String comment){
        return userCommentService.putComment(userId,bookId,comment);
    }

}
