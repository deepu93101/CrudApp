package com.deepxnshu.CrudApplication.repository;
import com.deepxnshu.CrudApplication.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class StudentRepository {
    public Student saveStudent(Student request){
        System.out.println("inside Student Repository");
        System.out.println("Exiting Student Repository");
        Student s1 = new Student();
        s1.setEmail("deepanshu@gmail.com");
        s1.setId(1);
        s1.setName("deepanshu");
        s1.setSubject("Spring");
        s1.setRollNo(10);
        return s1;
    }
}
