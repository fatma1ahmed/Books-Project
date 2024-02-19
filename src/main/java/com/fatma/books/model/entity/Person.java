package com.fatma.books.model.entity;

import com.fatma.books.model.dto.PersonUserAuthorDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@Builder
public class Person  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "please,enter your first Name")
    private String firstName;
    @NotNull(message = "please,enter your last Name")
    private String lastName;

    @Email
    @NotNull(message = "please,enter your email")
    @Column(unique = true)
    private String email;

    @NotNull(message = "please,enter your password")
    @NotEmpty
    @Size(min = 4,max = 18,message = "should enter your password between 4 and 18")
    @Column(unique = true)
    private String password;

    private String imagePath;

    public static Person toEntity(PersonUserAuthorDto dto) {
        return Person.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .imagePath(dto.getImagePath())
                .build();
    }

}
