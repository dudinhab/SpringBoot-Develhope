package com.example.demo.model;

import com.example.demo.entity.Course;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
        private Long id;
        private String fullName;
        private int age;
        private Long courseId;
}
