package com.fatma.books.model.dto;

import com.fatma.books.model.entity.Book;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequset {

    private int id;

    @NotNull(message = "please,enter bookName ")
    private String bookName;

    @NotNull(message = "please,enter description book ")
    @Size(min = 5,max = 50,message = "description book should be between 5 and 50")
    private String description;

    private String pdf;
    private int categoryId;
    private int authorId;


//    public static BookRequset fromEntityToDto(Book entity){
//        return BookRequset.builder()
//                .id(entity.getId())
//                .bookName(entity.getBookName())
//                .description((entity.getDescription()))
//                .pdf(entity.getPdf())
//                .build();
//    }
}
