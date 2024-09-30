package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
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
    public ResponseEntity addBook(@RequestBody Book b) {
        Book response = bookService.addBook(b);
        if (response != null) {
            return ResponseEntity.ok(b);
        }
        return ResponseEntity.status(404).body("Not Added!");
    }

    @GetMapping("/{id}")
    public ResponseEntity getBookById(@PathVariable("id") int id) {
        Book b = bookService.getBookById(id);
        if (b == null) {
            return ResponseEntity.status(404).body("ID not found!");
        }
        return ResponseEntity.ok(b);
    }

    @GetMapping("/all")
    public ResponseEntity getMapBook() {
        Map<Integer, Book> hashBook = bookService.getMapBook();
        if (hashBook.size() != 0) {
            return ResponseEntity.ok(hashBook);
        }
        return ResponseEntity.status(404).body("Not found any book!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remBookByID(@PathVariable("id") int id) {
        Book b = bookService.remBookByID(id);
        if (b == null) {
            return ResponseEntity.status(404).body("ID not found!");
        }
        return ResponseEntity.ok(b);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity editAuthor(@PathVariable("id") int id, @RequestBody(required = false) Author author, @RequestParam(required = false) String title, @RequestParam(required = false) String isbn, @RequestParam(required = false) LocalDate publishedDate) {
        Book b = bookService.editBook(id, author, title, isbn, publishedDate);
        if (b!=null) {
            return ResponseEntity.ok(b);
        }
        return ResponseEntity.status(404).body("ID not found!");
    }
}
