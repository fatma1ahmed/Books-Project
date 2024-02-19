package com.fatma.books.repositry;

import com.fatma.books.model.dto.PersonUserAuthorDto;
import com.fatma.books.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepo  extends JpaRepository<Author,Integer> {

    @Query(value = "select a from Author a where a.email= :email and a.password = :password")
    public Optional<Author> login(String email, String password);


}
