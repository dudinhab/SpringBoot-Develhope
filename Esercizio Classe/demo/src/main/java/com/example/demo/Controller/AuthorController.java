package com.example.demo.controller;

import com.example.demo.model.AuthorDTO;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping()
    public ResponseEntity<?> addAuthor(@RequestBody AuthorDTO author) {
        try {
            AuthorDTO a = authorService.addAuthor(author);
            return ResponseEntity.ok(a);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getListAuthor() {
        List<AuthorDTO> listAuthor = authorService.getListAuthor();
        if (listAuthor.isEmpty()) {
            return ResponseEntity.status(404).body("Not found any author");
        }
        return ResponseEntity.ok(listAuthor);
    }
}
