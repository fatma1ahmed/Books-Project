package com.fatma.books.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fatma.books.model.dto.PersonUserAuthorDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;

import java.util.List;


@Entity
@Table
public class Author extends Person{
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Book> books;


}
