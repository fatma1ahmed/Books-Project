package com.fatma.books.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatma.books.model.entity.Book;
import com.fatma.books.model.entity.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "please,enter categoryName ")
    private String categoryName;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Book> books;

    public static CategoryDto fromEntityToDto(Category entity){
        return CategoryDto.builder()
                .id(entity.getId())
                .categoryName(entity.getCategoryName())
                .books(entity.getBooks())
                .build();
    }
}
