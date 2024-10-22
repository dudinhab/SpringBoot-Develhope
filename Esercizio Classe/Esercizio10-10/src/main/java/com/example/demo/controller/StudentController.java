package com.example.demo.controller;

import com.example.demo.model.StudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.server.RemoteRef;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping()
    public ResponseEntity<?> addNewStudent(@RequestBody StudentDTO studentDTO){
        try{
            StudentDTO newStudent = studentService.addNewStudent(studentDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}
