package com.academywebsite.controller;

import com.academywebsite.documents.Students;
import com.academywebsite.service.StudentsService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Documentation of the Students of the IT academy", tags = {"Students"})
@RestController
@RequestMapping("/api")
public class StudentsController {

    @Autowired
    StudentsService studentsService;
    @GetMapping("/students")
    public List<Students> getAllStudents(){
        return studentsService.getAllStudents();
    }
    @GetMapping("/students/{id}")
    public Students getStudentById(@PathVariable String id){
        return studentsService.getStudentById(id);
    }

    @PostMapping("/students")
    public Students createStudent(@RequestBody Students student){
        return studentsService.createStudent(student);
    }
    @PutMapping("/students/{id}")
    public Students updateStudent(@PathVariable String id,@RequestBody Students student){
        return studentsService.updateStudent(id, student);
    }
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable String id){
        studentsService.deleteStudent(id);
    }
}
