package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.model.BookDTO;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("")
    public ResponseEntity<?> addBook(@RequestBody BookDTO bookDTO) throws Exception {
        BookDTO response = bookService.addBook(bookDTO);
        if (response != null) {
            return ResponseEntity.ok(bookDTO);
        }
        return ResponseEntity.status(404).body("Not Added!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable("id") int id) {
        BookDTO bookDTO = bookService.getBookById(id);
        if (bookDTO == null) {
            return ResponseEntity.status(404).body("ID not found!");
        }
        return ResponseEntity.ok(bookDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getMapBook() {
        List<BookDTO> listBookDTO = bookService.getListBookDTO();
        if (listBookDTO.isEmpty()) {
            return ResponseEntity.status(404).body("Not found any book!");
        }
        return ResponseEntity.ok(listBookDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remBookByID(@PathVariable("id") int id) {
        boolean DeleteBookDTO = bookService.remBookByID(id);
        if (DeleteBookDTO) {
            return ResponseEntity.status(404).body("ID not found!");
        }
        return ResponseEntity.ok().body("Deleted successfully!");
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<?> editBook(@PathVariable("id") int id, @RequestBody(required = false) Author author, @RequestParam(required = false) String title, @RequestParam(required = false) String isbn, @RequestParam(required = false) LocalDate publishedDate) {
        BookDTO bookDTO = bookService.editBook(id, author, title, isbn, publishedDate);
        if (bookDTO!=null) {
            return ResponseEntity.ok(bookDTO);
        }
        return ResponseEntity.status(404).body("ID not found!");
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> editAuthorComplete(@PathVariable("id") int id, @RequestBody Book book){
        Book newBook = book.builder().author(book.getAuthor()).title(book.getTitle()).isbn(book.getIsbn()).publishedDate( book.getPublishedDate()).id(id).build();
        if (newBook!=null) {
            return ResponseEntity.ok(newBook);
        }
        return ResponseEntity.status(404).body("ID not found!");
    }

}
