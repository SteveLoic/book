package com.steve.book.bookRespositoryTest;

import com.steve.book.book.Book;
import com.steve.book.book.BookRepository;
import com.steve.book.book.BookResponse;
import com.steve.book.common.AbstractionBaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.utility.TestcontainersConfiguration;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest  {

    @Autowired
    private BookRepository bookRepository;


    @Test
    void givenBooksList_whenSave_ReturnAllTheBooks(){
        List<Book> books = Arrays.asList(
                Book.builder()
                        .year(2000)
                        .title("spring boot with Steve")
                        .description("Best practices to use spring boot with github actions")
                        .author("steve")
                        .isbn(1233)
                        .build(),
                Book.builder()
                        .year(2000)
                        .title("React Apps with Steve")
                        .description("Best practices to use React with github actions")
                        .author("steve")
                        .isbn(1)
                        .build()
        );

        //SAVE
        List<Book> savedBook = bookRepository.saveAll(books);

        //Fetch All the Books
        List<Book> foundBooks = bookRepository.findAll();

        Assertions.assertEquals(foundBooks.size(),savedBook.size());
    }

}
