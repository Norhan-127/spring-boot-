package com.example.learning_with_amigous.student.repository;

import com.example.learning_with_amigous.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    //SELECT * FROM student WHERE email = ?
    Optional<Student> findStudentByEmail(String email);
    void deleteStudentById(Long id);


}
