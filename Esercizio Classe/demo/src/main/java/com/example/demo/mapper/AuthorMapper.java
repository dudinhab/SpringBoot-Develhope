package com.example.demo.mapper;

import com.example.demo.entity.Author;
import com.example.demo.model.AuthorDTO;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    public Author authorDTOFromAuthor(AuthorDTO authorDTO){
        return Author.builder().name(authorDTO.getName()).biography(authorDTO.getBiography()).build();
    }
    public AuthorDTO authorFromAuthorDTO(Author author){
        return AuthorDTO.builder().name(author.getName()).biography(author.getBiography()).build();
    }
}
