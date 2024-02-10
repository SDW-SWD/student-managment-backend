package edu.icet.student.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    int age;
}
