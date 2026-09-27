package com.abhi.studentmanagement.service;

import com.abhi.studentmanagement.model.Student;
import com.abhi.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
  private StudentRepository repo;

  public StudentService(StudentRepository repo){
    this.repo=repo;
  }


  //Create

  public Student addStudent(Student stu){
    return repo.save(stu);
  }

  //FindBy Id
  public Student getById(Long id){
    return repo.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
  }

}
