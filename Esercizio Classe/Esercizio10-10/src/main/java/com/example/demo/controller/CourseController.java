package com.example.demo.controller;

import com.example.demo.model.CourseDTO;
import com.example.demo.model.StudentDTO;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping("")
    public ResponseEntity<?> addNewCourse(@RequestParam String name){
        CourseDTO newCourseDTO = courseService.addNewCourse(name);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCourseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable("id") Long idCourse){
        try {
            CourseDTO courseDTOFound = courseService.getCourseDTOById(idCourse);
            return ResponseEntity.status(HttpStatus.FOUND).body(courseDTOFound);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAllCourses(){
        try {
            List<CourseDTO> allCoursesList = courseService.getAllCourses();
            return ResponseEntity.status(HttpStatus.FOUND).body(allCoursesList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}/student")
    public ResponseEntity<?> getAllCourses(@PathVariable("id") Long idCourse){
        try {
            List<StudentDTO> allStudentsCourseList = courseService.getAllStudents(idCourse);
            return ResponseEntity.status(HttpStatus.FOUND).body(allStudentsCourseList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateName(@RequestParam("name") String name, @PathVariable("id") Long idCourse){
        try {
            CourseDTO updatedCourse = courseService.updateCourseName(idCourse, name);
            return ResponseEntity.status(HttpStatus.FOUND).body(updatedCourse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") Long idCourse){
        courseService.deleteCourseById(idCourse);
        return ResponseEntity.ok("Course Deleted");
    }
}
