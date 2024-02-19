package com.fatma.books.service;

import com.fatma.books.model.entity.Star;
import com.fatma.books.model.entity.UserComment;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserCommentService {
    public ResponseEntity<?> putComment(int userId, int bookId, String comment);

    public Optional<UserComment> findCommentByUserIdAndBookId(int bookId, int userId);
}
