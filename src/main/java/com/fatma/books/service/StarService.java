package com.fatma.books.service;

import com.fatma.books.model.dto.StarDto;
import com.fatma.books.model.entity.Star;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface StarService {
    public ResponseEntity<?> putStar(int userId,int bookId,int numOfStar);

    public Optional<Star> findStarByUserIdAndBookId(int userId, int bookId);
}
