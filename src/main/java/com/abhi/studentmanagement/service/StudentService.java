package com.abhi.studentmanagement.service;

import com.abhi.studentmanagement.model.Student;
import com.abhi.studentmanagement.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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


  //Find All
  public List<Student> getAllStudent(){
    return repo.findAll();
  }

  public Student UpdateStudent(Long id, Student updateStud){
    Student stu= getById(id);

    stu.setName(updateStud.getName());
    stu.setCourse(updateStud.getCourse());
    stu.setEmail(updateStud.getEmail());
    stu.setAge(updateStud.getAge());

    return repo.save(stu);

  }

  public void DeleteById(Long id){
    Student stud= getById(id);
    repo.delete(stud);


  }

}
