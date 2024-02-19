package com.fatma.books.model.entity;

import com.fatma.books.model.dto.StarDto;
import com.fatma.books.model.dto.UserCommentDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class UserComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private  String comment;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    public static UserComment toEntity(UserCommentDto dto){
        return UserComment.builder()
                .id(dto.getId())
                .user(dto.getUser())
                .book(dto.getBook())
                .comment(dto.getComment())
                .build();
    }


}
