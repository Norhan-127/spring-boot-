package com.example.learning_with_amigous.student.controller;

import com.example.learning_with_amigous.student.entity.Student;
import com.example.learning_with_amigous.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
       return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "{studentID}")
    public void deleteStudentById(@PathVariable Long studentID){
        studentService.deleteStudentById(studentID);

    }

    @PutMapping(name = "updateTheStudentName",path = "{studentID}")
    public void updateTheStudentName(@PathVariable Long studentID,@RequestParam(required = false) String studentName,@RequestParam(required = false) String studentEmail){
        studentService.updateTheStudentNameAndEmail(studentID,studentName,studentEmail);
    }
}
