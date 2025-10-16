package com.steve.book.book;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookRequest {

    @NotBlank(message = "title must be not empty")
    @NotNull(message ="description must be not null")
    private String title;

    @NotBlank(message = "author must be not empty")
    @NotNull(message ="description must be not null")
    private String author;

    @NotNull(message ="description must be not null")
    private int isbn;

    @NotBlank(message = "description must be not empty")
    @NotNull(message ="description must be not null")
    private String description;
}
