package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.CourseDTO;
import com.example.demo.model.StudentDTO;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentMapper studentMapper;

    public CourseDTO addNewCourse(String nome) {
        Course course = new Course();
        course.setNameCourse(nome);
        courseRepository.save(course);
        return courseMapper.courseToCourseDTO(course);
    }

    public CourseDTO getCourseDTOById(Long idCourse) throws Exception {
        Course courseFound = courseRepository.getReferenceById(idCourse);
        if (courseFound == null) {
            throw new Exception("Id not found!");
        }
        return courseMapper.courseToCourseDTO(courseFound);
    }

    public Course getCourseById(Long idCourse) throws Exception {
        Course courseFound = courseRepository.getReferenceById(idCourse);
        if (courseFound == null) {
            throw new Exception("Id not found!");
        }
        return courseFound;
    }

    public List<CourseDTO> getAllCourses() throws Exception {
        List<Course> courseList = courseRepository.findAll();
        List<CourseDTO> courseDTOList = new ArrayList<>();
        courseList.forEach(a->courseDTOList.add(courseMapper.courseToCourseDTO(a)));
        if (courseDTOList.isEmpty()){
            throw new Exception("Course list is empty!");
        }
        return courseDTOList;
    }

    public List<StudentDTO> getAllStudents(Long idCourse) throws Exception {
        List<Student> studentList = courseRepository.getReferenceById(idCourse).getStudentList();
        List<StudentDTO> studentDTOList = new ArrayList<>();
        studentList.forEach(a->studentDTOList.add(studentMapper.studentToStudentDTO(a)));
        if (studentDTOList.isEmpty()){
            throw new Exception("Students list is empty!");
        }
       return studentDTOList;
    }

    public CourseDTO updateCourseName(Long idCourse, String name) throws Exception {
        Course courseFound = getCourseById(idCourse);
        courseFound.setNameCourse(name);
        courseRepository.save(courseFound);
        return courseMapper.courseToCourseDTO(courseFound);
    }

    public void deleteCourseById(Long idCourse) {
        courseRepository.deleteById(idCourse);
    }
}
