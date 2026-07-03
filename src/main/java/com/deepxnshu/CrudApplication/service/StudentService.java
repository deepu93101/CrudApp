package com.deepxnshu.CrudApplication.service;
import com.deepxnshu.CrudApplication.entity.Student;
import com.deepxnshu.CrudApplication.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;

    }
    public Student createStudent(Student req){
        System.out.println("Inside Student Service");
        Student response = studentRepository.saveStudent(req);
        System.out.println("Exiting Student Service");
        return response;
    }
}
