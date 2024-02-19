package com.fatma.books.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatma.books.model.dto.BookRequset;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "please,enter bookName ")
    private String bookName;

    @NotNull(message = "please,enter description book ")
    @Size(min = 5,max = 50,message = "description book should be between 5 and 50")
    private String description;

    private String pdf;

    @ManyToOne
    private Category category;

    @ManyToOne
//    @JsonIgnore
    private Author author;


    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Star> stars;

    public static Book toEntity(BookRequset dto){
        return Book.builder()
                .id(dto.getId())
                .bookName(dto.getBookName())
                .description((dto.getDescription()))
                .pdf(dto.getPdf())
                .build();
    }
}
