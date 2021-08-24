package com.tw.bootcamp.bookshop.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    List<Book> list(@RequestParam("sortBy") String sortByColumn,
                    @RequestParam("sortOrder")String sortOrder) {
        return bookService.fetchAll(sortByColumn, sortOrder);
    }
}
