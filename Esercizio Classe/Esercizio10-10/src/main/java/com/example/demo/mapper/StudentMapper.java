package com.example.demo.mapper;

import com.example.demo.entity.Student;
import com.example.demo.model.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student studentDTOToStudent(StudentDTO studentDTO){
        return Student.builder().id(studentDTO.getId()).idCourse(studentDTO.getCourseId()).age(studentDTO.getAge()).fullName(studentDTO.getFullName()).build();
    }
    public StudentDTO studentToStudentDTO(Student student){
        return StudentDTO.builder().id(student.getId()).courseId(student.getIdCourse()).age(student.getAge()).fullName(student.getFullName()).build();
    }
}
