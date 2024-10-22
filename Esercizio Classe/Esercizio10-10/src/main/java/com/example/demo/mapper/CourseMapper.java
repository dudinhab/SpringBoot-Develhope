package com.example.demo.mapper;

import com.example.demo.entity.Course;
import com.example.demo.model.CourseDTO;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public CourseDTO courseToCourseDTO(Course course){
        return CourseDTO.builder().idCourse(course.getIdCourse()).nameCourse(course.getNameCourse()).idCourse(course.getIdCourse()).listStudent(course.getStudentList()).build();
    }
    public Course courseDTOToCourse(CourseDTO courseDTO){
        return Course.builder().idCourse(courseDTO.getIdCourse()).nameCourse(courseDTO.getNameCourse()).idCourse(courseDTO.getIdCourse()).studentList(courseDTO.getListStudent()).build();
    }
}
