package com.fatma.books.service;

import com.fatma.books.model.dto.BookRequset;
import com.fatma.books.model.dto.StarDto;
import com.fatma.books.model.entity.Book;
import com.fatma.books.model.entity.Star;
import com.fatma.books.model.entity.User;
import com.fatma.books.repositry.StarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class StarServiceImp implements StarService {

    @Autowired
    private StarRepo starRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private BookService bookService;

    @Override
    public ResponseEntity<?> putStar(int userId, int bookId, int numOfStar) {
User user= userService.getUserById(userId);
Book book=bookService.getBookById(bookId);

      Optional<Star> star1=  findStarByUserIdAndBookId(userId,bookId);
        if(star1.isPresent()){
            StarDto existingStar= StarDto.fromEntityToDto(star1.get());
            existingStar.setNumOfStars(numOfStar);
           StarDto.fromEntityToDto( starRepo.save(Star.toEntity(existingStar)));
            return  ResponseEntity.ok("update star");
        }
        else {
            StarDto createStar = new StarDto();
            createStar.setUser(user);
            createStar.setBook(book);
            createStar.setNumOfStars(numOfStar);
            StarDto.fromEntityToDto( starRepo.save(Star.toEntity(createStar)));
            return  ResponseEntity.ok("create new star");

        }


    }

    public Optional<Star> findStarByUserIdAndBookId(int userId , int bookId){

         return starRepo.findStarByUserIdAndBookId(userId,bookId);



    }
}
