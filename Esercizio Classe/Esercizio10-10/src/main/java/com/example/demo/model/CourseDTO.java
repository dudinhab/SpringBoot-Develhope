package com.example.demo.model;

import com.example.demo.entity.Student;
import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {
        private Long idCourse;
        private String nameCourse;
        private List<Student> listStudent;
}
