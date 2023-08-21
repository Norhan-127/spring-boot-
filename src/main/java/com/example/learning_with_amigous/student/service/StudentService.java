package com.example.learning_with_amigous.student.service;

import com.example.learning_with_amigous.student.entity.Student;
import com.example.learning_with_amigous.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {


    private final StudentRepository studentRepository;// -------------------After creating repository interface------------------------


    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //    -------------------------------------------------------------------------------
//    -------------------Before creating repository interface------------------------
//    -------------------------------------------------------------------------------
//    public List<Student> getStudents() {
//        return Collections.singletonList(new Student(
//                1L,
//                "Nour",
//                LocalDate.of(2002, 7, 12),
//                "Nour@@gmail",
//                21
//
//        ));
//    }
//    -------------------------------------------------------------------------------
//    -------------------------------------------------------------------------------
//    -------------------After creating repository interface------------------------
//    -------------------------------------------------------------------------------
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.
                findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    @Transactional
    public void deleteStudentById(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (exists) {
            studentRepository.deleteStudentById(id);
        } else {
            throw new IllegalStateException("Student id with id: " + id + " dose not exist");
        }
    }

    @Transactional
    public void updateTheStudentNameAndEmail(Long id, String studentName,String studentEmail ) {
        Student student = studentRepository.findById(id).
                orElseThrow(
                        () -> new IllegalStateException("Student id with id: " + id + " dose not exist")
                );
        if (!studentName.isEmpty() && !Objects.equals(student.getName(),studentName)) {
            student.setName(studentName);
        }
        if (!studentEmail.isEmpty() && !Objects.equals(student.getEmail(), studentEmail)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(studentEmail);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email taken");
            }
            student.setEmail(studentEmail);
    }
    }
}
