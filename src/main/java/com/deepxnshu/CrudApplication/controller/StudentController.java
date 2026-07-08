package com.deepxnshu.CrudApplication.controller;

import com.deepxnshu.CrudApplication.entity.Student;
import com.deepxnshu.CrudApplication.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    public StudentController(StudentService studentService)
    {
        this.studentService= studentService;
    }
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

      Student create =   studentService.createStudent(student);
      return ResponseEntity
              .status(HttpStatus.CREATED)
              .body(create);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> readStudent(@PathVariable Long id ){
        Student read = studentService.readStudent(id);
        if(read==null){
        return ResponseEntity.notFound().build();

    }
    return ResponseEntity.status(HttpStatus.FOUND).body(read);
    }

@GetMapping("/getAll")
    public ResponseEntity<List<Student>> readAllStudent(){
List<Student> recieve=studentService.getAll();
        if (recieve == null) {

            return ResponseEntity.status(HttpStatus.FOUND).body(recieve);
        }
return ResponseEntity.status(HttpStatus.FOUND).body(recieve);
    }
@PutMapping("/update/{id}")
    public ResponseEntity<Student> tStudent(@PathVariable long  id ,@RequestBody Student S){
Student student = studentService.studentUpdate(id,S);
return ResponseEntity.status(HttpStatus.FOUND).body(student);
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeStudent(@PathVariable Long id){
        Boolean removeStudent = studentService.deleteStudent(id);
        if(!removeStudent){
            return ResponseEntity.notFound().build();
        }return ResponseEntity.status(HttpStatus.OK).body("Record Deleted ");
    }

}



