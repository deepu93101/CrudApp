package com.deepxnshu.CrudApplication.repository;
import com.deepxnshu.CrudApplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
public interface StudentRepository extends JpaRepository<Student,Long> {

}
