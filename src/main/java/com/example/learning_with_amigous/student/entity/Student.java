package com.example.learning_with_amigous.student.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Data
@AllArgsConstructor
@Entity
@Table
@NoArgsConstructor
public class Student {
    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private long id;
    private String name;
    private LocalDate dob;
    private String email;
    @Transient
    private Integer age;

    public Student(String name, LocalDate dob, String email) {
        this.name = name;
        this.dob = dob;
        this.email = email;
    }

    public Integer getAge(){
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

}
