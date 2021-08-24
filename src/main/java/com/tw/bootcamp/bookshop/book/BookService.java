package com.tw.bootcamp.bookshop.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> fetchAll() {
        return bookRepository.findAllByOrderByPriceDesc();
    }

    public List<Book> fetchAll(boolean asc) {
        if(asc) {
            return bookRepository.findAllByOrderByPriceAsc();
        }else{
            return bookRepository.findAllByOrderByPriceDesc();
        }
    }

    public List<Book> fetchAll(Sort sort){
        return bookRepository.findAll(sort);
    }
}
