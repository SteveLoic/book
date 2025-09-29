package com.steve.book.book;


import com.steve.book.common.Response;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Tag(name = "books")
public class BookController {

    @GetMapping("/all")
    public ResponseEntity<Response> fetchAllBooks() {
        List<BookResponse> bookResponseList = Arrays.asList(
                BookResponse.builder().build(),
                BookResponse.builder().build()
        );
        Response response = Response.builder().status(200)
                .message(String.format("Retrieve all books was successfull"))
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<Response> fetchBook(@PathVariable("bookId") Long bookId) {
          Response response = Response.builder().status(200)
                  .message(String.format("Retrieve book with %d was successfull", bookId))
                  .build();
          return ResponseEntity.ok().body(response);

    }
}
