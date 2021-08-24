package com.tw.bootcamp.bookshop.book;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String authorName;
    private Integer price;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    private Integer count;

    public Book() {
    }

    public Book(String name, String authorName, Integer price) {
        this.name = name;
        this.authorName = authorName;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Integer getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }
}
