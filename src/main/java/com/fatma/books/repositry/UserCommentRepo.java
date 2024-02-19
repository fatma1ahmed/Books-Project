package com.fatma.books.repositry;

import com.fatma.books.model.entity.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCommentRepo extends JpaRepository<UserComment,Integer> {
    Optional<UserComment> findCommentByUserIdAndBookId(int userId,int BookId);
}
