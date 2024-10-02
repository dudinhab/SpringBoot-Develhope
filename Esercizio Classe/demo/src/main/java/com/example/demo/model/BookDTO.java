package com.example.demo.model;

import com.example.demo.entity.Author;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    private Integer id;
    private String title;
    private String isbn;
    private Author author;
    private LocalDate publishedDate;

}
