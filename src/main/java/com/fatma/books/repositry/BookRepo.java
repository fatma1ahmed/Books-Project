package com.fatma.books.repositry;


import com.fatma.books.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface BookRepo  extends JpaRepository<Book,Integer> {
    //@Query(value = "select * from book b where b.book_name= :bookName", nativeQuery = true)
    Optional<Book> findByBookName(String bookName);



}