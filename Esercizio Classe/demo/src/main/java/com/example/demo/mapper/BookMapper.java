package com.example.demo.mapper;

import com.example.demo.entity.Book;
import com.example.demo.model.BookDTO;

public class BookMapper {
    public Book bookDTOFromBook(BookDTO bookDTO){
        return Book.builder().author(bookDTO.getAuthor()).title(bookDTO.getTitle()).isbn(bookDTO.getIsbn()).publishedDate(bookDTO.getPublishedDate()).build();
    }
    public BookDTO bookFromBookDTO(Book book){
        return BookDTO.builder().author(book.getAuthor()).title(book.getTitle()).isbn(book.getIsbn()).publishedDate(book.getPublishedDate()).build();
    }
}
