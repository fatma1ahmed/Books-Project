package com.fatma.books.repositry;

import com.fatma.books.model.dto.StarDto;
import com.fatma.books.model.entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StarRepo extends JpaRepository<Star,Integer> {
    public Optional<Star> findStarByUserIdAndBookId(int userId, int bookId);
}
