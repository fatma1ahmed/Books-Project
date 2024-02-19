package com.fatma.books.repositry;

import com.fatma.books.model.entity.Author;
import com.fatma.books.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepo extends JpaRepository<User,Integer> {
    @Query(value = "select * from user a where a.email= :email and a.password = :password",nativeQuery = true)
    Optional<User> login(String email, String password);

    @Query(value = "select * from user a where a.email= :email ",nativeQuery = true)
    Optional<User> findByEmail(String email);
}
