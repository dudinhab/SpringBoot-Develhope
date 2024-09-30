package com.example.demo.service;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BookService {
    Map<Integer, Book> mapBook = new HashMap<>();
    AtomicInteger autoIncrement = new AtomicInteger();

    public Book addBook(Book b) {
        int id = autoIncrement.incrementAndGet();
        b.setId(id);
        mapBook.put(id, b);
        return mapBook.get(id);
    }

    public Book getBookById(int id){
        return mapBook.get(id);
    }

    public Map<Integer, Book> getMapBook(){
        return this.mapBook;
    }

    public Book remBookByID(int id){
        return mapBook.remove(id);
    }

    public Book editAuthor(int id, Author author){
        mapBook.get(id).setAuthor(author);
        return mapBook.get(id);
    }

    public Book editTitle(int id, String title){
        mapBook.get(id).setTitle(title);
        return mapBook.get(id);
    }

    public Book editISBN(int id, String isbn){
        mapBook.get(id).setIsbn(isbn);
        return mapBook.get(id);
    }

    public Book editPublishedDate(int id, LocalDate publishedDate){
        mapBook.get(id).setPublishedDate(publishedDate);
        return mapBook.get(id);
    }
}
