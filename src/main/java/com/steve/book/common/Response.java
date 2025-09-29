package com.steve.book.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.steve.book.book.BookResponse;
import lombok.*;

import java.util.List;


@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    int status;
    String message;
    BookResponse bookResponse;
    List<BookResponse> bookResponseList;

}
