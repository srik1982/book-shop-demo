package com.tw.bootcamp.bookshop.book;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @AfterEach
    void tearDown() {
        bookRepository.deleteAll();
    }

    @Test
    void shouldFetchAllBooks() {
        Book book = new Book("title", "author name", 300);
        bookRepository.save(book);

        List<Book> books = bookService.fetchAll();

        assertEquals(1, books.size());
        assertEquals("title", books.get(0).getName());
    }

    @Test
    void shouldFetchAllBooksBeSortedByPrice() {
        Book lowPrice = new Book("title", "author name", 300);
        Book highPrice = new Book("costlier", "author name", 400);
        bookRepository.save(lowPrice);
        bookRepository.save(highPrice);

        List<Book> books = bookService.fetchAll();

        assertEquals(2, books.size());
        assertEquals("costlier", books.get(0).getName());
    }

    @Test
    void shouldFetchAllBooksBeSortedByPriceAsc() {
        Book lowPrice = new Book("title", "author name", 300);
        Book highPrice = new Book("costlier", "author name", 400);
        bookRepository.save(lowPrice);
        bookRepository.save(highPrice);

        List<Book> books = bookService.fetchAll(Sort.by(Sort.Direction.ASC, "price"));

        assertEquals(2, books.size());
        assertEquals("title", books.get(0).getName());
        assertEquals(300, books.get(0).getPrice());
    }

    @Test
    void shouldFetchAllBooksBeSortedByAuthorNameAsc() {
        Book lowPrice = new Book("title", "Srikanth", 300);
        Book highPrice = new Book("costlier", "Shashank", 400);
        bookRepository.save(lowPrice);
        bookRepository.save(highPrice);

        List<Book> books = bookService.fetchAll(Sort.by(Sort.Direction.ASC, "authorName"));

        assertEquals(2, books.size());
        assertEquals("Shashank", books.get(0).getAuthorName());
        assertEquals(400, books.get(0).getPrice());
    }
}