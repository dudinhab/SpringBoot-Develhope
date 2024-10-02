package com.example.demo.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorDTO {
    private int id;
    private String name;
    private String biography;
}
