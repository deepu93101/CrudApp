package com.deepxnshu.CrudApplication.service;
import com.deepxnshu.CrudApplication.entity.Student;
import com.deepxnshu.CrudApplication.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;

    }
    public Student createStudent(Student req){
        req.setDeleted(false);
        Student response = studentRepository.save(req);
        ;
        return response;
    }
    public Student readStudent(Long ID){
        Optional<Student> response = studentRepository.findById(ID);
        if(response.isPresent()){
            return response.get();
        }
        return null;

    }
    public List<Student> getAll(){
        List<Student> response = studentRepository.findAll();
        return response;
    }
    public boolean deleteStudent(long id ) {
        Boolean isStudent = studentRepository.existsById(id);
        if (!isStudent){
            return false;
        }
       studentRepository.deleteById(id);
return true;
    }
    public Student studentUpdate(long id,Student s){
Optional<Student> up = studentRepository.findById(id);
if(up==null){
    return null;
}
Student studentToSave = up.get();
studentToSave.setId(s.getId());
studentToSave.setSubject(s.getSubject());
studentToSave.setEmail(s.getEmail());
studentToSave.setName(s.getName());
studentToSave.setRollNo(s.getRollNo());
 studentRepository.save(studentToSave);
 return studentToSave;
    }


}
