package com.fatma.books.service;

import com.fatma.books.model.dto.BookRequset;
import com.fatma.books.model.dto.UserCommentDto;
import com.fatma.books.model.entity.Book;
import com.fatma.books.model.entity.User;
import com.fatma.books.model.entity.UserComment;
import com.fatma.books.repositry.UserCommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommentServiceImp implements UserCommentService {
    @Autowired
    private UserCommentRepo userCommentRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @Override
    public ResponseEntity<?> putComment(int userId, int bookId, String comment) {
        User user=userService.getUserById(userId);
        Book book=bookService.getBookById(bookId);
        Optional<UserComment> userComment= findCommentByUserIdAndBookId(userId,bookId);
        if(userComment.isPresent()){
            UserCommentDto existingComment= UserCommentDto.fromEntityToDto(userComment.get());
            existingComment.setComment(comment);
            userCommentRepo.save(UserComment.toEntity(existingComment));
            return ResponseEntity.ok("update comment");
        }else {
            UserCommentDto createComment=new UserCommentDto();
            createComment.setUser(user);
            createComment.setBook(book);
            createComment.setComment(comment);
            userCommentRepo.save(UserComment.toEntity(createComment));
            return ResponseEntity.ok("create new comment");
        }

    }

    @Override
    public Optional<UserComment> findCommentByUserIdAndBookId(int userId, int bookId) {
        return userCommentRepo.findCommentByUserIdAndBookId(userId, bookId);
    }
}
