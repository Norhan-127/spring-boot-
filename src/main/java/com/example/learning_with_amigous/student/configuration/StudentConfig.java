package com.example.learning_with_amigous.student.configuration;

import com.example.learning_with_amigous.student.entity.Student;
import com.example.learning_with_amigous.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;


@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            // Code to be executed when the Spring application starts
            Student nour = new Student(
                    "Nour",
                    LocalDate.of(2004, 7, 12),
                    "Nour@@gmail"

            );
            Student ziad = new Student(
                    "Ziad",
                    LocalDate.of(2002, 5, 10),
                    "ziad@@gmail"

            );
            //to save in database? ---> invoke our repo
            studentRepository.saveAll(
                    Arrays.asList(nour,ziad)
            );
        };
    }
//    @Bean: This annotation is used on a method to declare that it produces a bean managed by the Spring container.
//    In this case, the method commandLineRunner() produces a CommandLineRunner bean.

}
