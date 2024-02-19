package com.fatma.books.model.dto;

import com.fatma.books.model.entity.Book;
import com.fatma.books.model.entity.Star;
import com.fatma.books.model.entity.User;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StarDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Min(value = 1)
    @Max(value = 5)
    private  int numOfStars;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    public static StarDto fromEntityToDto(Star entity){
        return StarDto.builder()
                .id(entity.getId())
                .user(entity.getUser())
                .book(entity.getBook())
                .numOfStars(entity.getNumOfStars())
                .build();
    }


}
