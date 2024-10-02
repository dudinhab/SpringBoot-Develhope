package com.example.demo.service;

import com.example.demo.mapper.AuthorMapper;
import com.example.demo.model.AuthorDTO;
import com.example.demo.entity.Author;
import com.example.demo.repository.AuthorRepository;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    AuthorMapper authorMapper;

    public AuthorDTO addAuthor(AuthorDTO author) throws Exception{
        if (StringUtils.isNullOrEmpty(author.getName())){
            throw new Exception("Name null!");
        }
        Author newAuthor = authorRepository.save(authorMapper.authorDTOFromAuthor(author));

        return authorMapper.authorFromAuthorDTO(newAuthor);
    }

    public List<AuthorDTO> getListAuthor(){
        List<Author> listAuthor = new ArrayList<>();
        List<AuthorDTO> listAuthorDTO = new ArrayList<>();
        listAuthor.addAll(authorRepository.findAll());
        for (Author i : listAuthor){
            listAuthorDTO.add(authorMapper.authorFromAuthorDTO(i));
        }

        return listAuthorDTO;
    }
}
