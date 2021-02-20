package com.kvks.demo.controller;

import com.kvks.demo.model.Student;
import com.kvks.demo.service.StudentServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

   @GetMapping(value = "/students/")
   public ResponseEntity<List<Student>> getStudents(){
       List<Student> lstStudents = studentServiceImpl.getStudents();
       return new ResponseEntity<>(lstStudents, HttpStatus.OK);
   }

   @GetMapping(value = "/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable(name = "id") Long id){
        Student student = studentServiceImpl.getStudent(id);
       return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping(value = "/students/")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student savedStudent = studentServiceImpl.createStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.OK);
    }

    @PutMapping(value = "/students/")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student updatedStudent = studentServiceImpl.updateStudent(student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping(value = "/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") Long id){
        studentServiceImpl.deleteStudent(id);
        return new ResponseEntity<>("Student with id:"+ id +" deleted successfully", HttpStatus.OK);
    }
}
