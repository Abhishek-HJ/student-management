package com.abhi.studentmanagement.controller;

import com.abhi.studentmanagement.model.Student;
import com.abhi.studentmanagement.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service){
        this.service=service;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@RequestBody Student student){
        return service.addStudent(student);
    }


    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return service.getAllStudent();
    }



    @GetMapping("/{id}")
    public Student GetStudentById(@PathVariable Long id){
        return service.getById(id);
    }



    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student st){
        return service.UpdateStudent(id,st);
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id){
        service.DeleteById(id);
    }

}
