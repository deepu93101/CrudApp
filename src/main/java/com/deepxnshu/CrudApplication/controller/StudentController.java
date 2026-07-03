package com.deepxnshu.CrudApplication.controller;

import com.deepxnshu.CrudApplication.entity.Student;
import com.deepxnshu.CrudApplication.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService)
    {
        this.studentService= studentService;
    }
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        System.out.println("Inside Student Controller");
      Student create =   studentService.createStudent(student);
        System.out.println("Exiting Student Controller");
      return create;
    }
}
