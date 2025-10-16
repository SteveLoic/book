package com.steve.book.bookRespositoryTest;

import com.steve.book.book.Book;
import com.steve.book.book.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest  {

    @Autowired
    private BookRepository bookRepository;

    private List<Book> initialBooks;

    @BeforeEach
    void setUp() {
        bookRepository.deleteAll();

        initialBooks = Arrays.asList(
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
                        .isbn(1344)
                        .build()
        );

    }

    @Test
    void givenBooksList_whenSave_ReturnAllTheBooks(){
        //SAVE
        List<Book> savedBook = bookRepository.saveAllAndFlush(initialBooks);

        //Fetch All the Books
        List<Book> foundBooks = bookRepository.findAll();

        //
        Assertions.assertEquals(foundBooks.size(),savedBook.size());
    }


    @Test
    void givenBooks_whenUpdate_ReturnUpdatedBooks(){
        //SAVE
        bookRepository.saveAllAndFlush(initialBooks);

        //Find the book to be updated
         Book bookToBeUpdated = bookRepository.findByIsbn(1344);

        // Update values
        bookToBeUpdated.setTitle("Spring Boot und React mit GitHub Pipeline");
        bookToBeUpdated.setDescription("Best practices to use React with Spring Boot Pipeline");

        // SAVE updated
        Book updatedBook = bookRepository.saveAndFlush(bookToBeUpdated);

        // VERIFY
        Assertions.assertEquals("Spring Boot und React mit GitHub Pipeline", updatedBook.getTitle());
        Assertions.assertEquals("Best practices to use React with Spring Boot Pipeline", updatedBook.getDescription());
    }


    @Test
    void givenBooks_whenDelete_ReturnDeletedBook(){
        //SAVE
        bookRepository.saveAllAndFlush(initialBooks);

        //Find the book to be updated
        bookRepository.delete(bookRepository.findByIsbn(1344));

        // Retrieve all Book
        List<Book> allBooks = bookRepository.findAll();

        Assertions.assertEquals(allBooks.size(),1);

    }

}
