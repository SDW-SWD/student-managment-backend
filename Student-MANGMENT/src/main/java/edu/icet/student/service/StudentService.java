package edu.icet.student.service;

import edu.icet.student.dto.Student;
import edu.icet.student.entity.StudentEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    StudentEntity createStudent(Student student);
     List<Student> retrieveStudents();
     boolean removeStudent(Long studentId);

}
