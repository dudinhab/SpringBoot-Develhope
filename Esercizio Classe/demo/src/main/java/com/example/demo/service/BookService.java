package com.example.demo.service;

import com.example.demo.mapper.BookMapper;
import com.example.demo.model.BookDTO;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookMapper bookMapper;

    public BookDTO addBook(BookDTO bookDTO) throws Exception {
        if (StringUtils.isNullOrEmpty(bookDTO.getTitle())) {
            throw new Exception("Title null!");
        }
        Book newBook = bookRepository.save(bookMapper.bookDTOFromBook(bookDTO));
        return bookMapper.bookFromBookDTO(newBook);
    }

    public BookDTO getBookById(Integer id) {
        return bookMapper.bookFromBookDTO(bookRepository.getReferenceById(id));
    }

    public List<BookDTO> getListBookDTO() {
        List<Book> listBook = bookRepository.findAll();
        List<BookDTO> listBookDTO = new ArrayList<>();
        listBook.forEach(i -> bookMapper.bookFromBookDTO(i));
        return listBookDTO;
    }

    public boolean remBookByID(int id) {
        bookRepository.deleteById(id);
        return true;
    }

    public BookDTO editAuthor(int id, Author author) {
        Book book = bookRepository.getReferenceById(id);
        book.setAuthor(author);
        BookDTO newBookDTO = bookMapper.bookFromBookDTO(bookRepository.save(book));
        return newBookDTO;
    }

    public BookDTO editTitle(int id, String title) {
        Book book = bookRepository.getReferenceById(id);
        book.setTitle(title);
        BookDTO newBookDTO = bookMapper.bookFromBookDTO(bookRepository.save(book));
        return newBookDTO;
    }

    public BookDTO editISBN(int id, String isbn) {
        Book book = bookRepository.getReferenceById(id);
        book.setIsbn(isbn);
        BookDTO newBookDTO = bookMapper.bookFromBookDTO(bookRepository.save(book));
        return newBookDTO;
    }

    public BookDTO editPublishedDate(int id, LocalDate publishedDate) {
        Book book = bookRepository.getReferenceById(id);
        book.setPublishedDate(publishedDate);
        BookDTO newBookDTO = bookMapper.bookFromBookDTO(bookRepository.save(book));
        return newBookDTO;
    }

    public BookDTO editBook(int id, Author author, String title, String isbn, LocalDate publishedDate) {
        BookDTO bookDTO = null;
        if (bookRepository.existsById(id)) {
            if (author != null) {
                bookDTO = editAuthor(id, author);
            }
            if (StringUtils.isNullOrEmpty(title)) {
                bookDTO = editTitle(id, title);
            }
            if (StringUtils.isNullOrEmpty(isbn)) {
                bookDTO = editISBN(id, isbn);
            }
            if (publishedDate != null) {
                bookDTO = editPublishedDate(id, publishedDate);
            }
        }
        return bookDTO;
    }

    public BookDTO editBookCompleteBuild(BookDTO bookDTO, int id){
        Book newBook = Book.builder().author(bookDTO.getAuthor()).title(bookDTO.getTitle()).isbn(bookDTO.getIsbn()).publishedDate(bookDTO.getPublishedDate()).id(id).build();
        return bookMapper.bookFromBookDTO(newBook);
    }
}
