package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "book")
public class Book {
    @Id
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="isbn")
    private String isbn;
    @OneToOne(mappedBy ="id")
    private Author author;
    @Column(name="publishedDate")
    private LocalDate publishedDate;

}
