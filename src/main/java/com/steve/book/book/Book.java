package com.steve.book.book;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title must be not null")
    @NotNull(message = "Title must be not null")
    private String title;

    @NotBlank(message = "Author must be not null")
    @NotNull(message = "Author must be not null")
    private String author;

    @NotNull(message = "ISBN must be not null")
    @Column(unique = true)
    private int isbn;

    @NotBlank(message = "Description must be not null")
    @NotNull(message = "Description must be not null")
    private String description;

    @NotNull(message = "Year must be not null")
    private int year;
}
