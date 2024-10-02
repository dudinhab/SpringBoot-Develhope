package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.Name;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "author")
public class Author {
    @Id
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="biography")
    private String biography;

}
