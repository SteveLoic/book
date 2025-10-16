package com.steve.book.book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBookByTitle(String title);

    Book findByIsbn(int isbn);

}
