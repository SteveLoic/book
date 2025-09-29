package com.steve.book.book;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponse {

    private String title;
    private String author;
    private String isbn;
    private String description;
    private int year;

}
