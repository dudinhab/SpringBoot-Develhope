package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.StudentDTO;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseService courseService;

    public List<StudentDTO> getStudentListToDTO(List<Student> studentList) {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        studentList.forEach(a->studentDTOList.add(studentMapper.studentToStudentDTO(a)));
        return studentDTOList;
    }

    public StudentDTO addNewStudent(StudentDTO studentDTO) throws Exception {
        Student newStudent = studentMapper.studentDTOToStudent(studentDTO);
        Long courseId = newStudent.getIdCourse();
        if ((courseService.getCourseById(courseId)==null)&&(courseId!=null)){
            throw new Exception("Id course not found!");
        }
        studentRepository.save(newStudent);
        return studentMapper.studentToStudentDTO(newStudent);
    }
}
