package com.fatma.books.controller;

import com.fatma.books.model.entity.Star;
import com.fatma.books.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
@CrossOrigin("*")
public class StarController {
    @Autowired
    private StarService starService;

    @PostMapping("/putStar/{userId}/{bookId}/{numOfStar}")
    public ResponseEntity<?> putStar(@PathVariable int userId,@PathVariable int bookId,@PathVariable int numOfStar){
        return starService.putStar(userId,bookId,numOfStar);
    }

}
