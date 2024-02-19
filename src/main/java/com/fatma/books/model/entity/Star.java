package com.fatma.books.model.entity;

import com.fatma.books.model.dto.StarDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Builder
public class Star {
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

    public static Star toEntity(StarDto dto){
        return Star.builder()
                .id(dto.getId())
                .user(dto.getUser())
                .book(dto.getBook())
                .numOfStars(dto.getNumOfStars())
                .build();
    }



}
