package edu.icet.student.controller;

import edu.icet.student.dto.Student;
import edu.icet.student.entity.StudentEntity;
import edu.icet.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping("/postStudents")
    StudentEntity createStudent(@RequestBody Student student){
        return service.createStudent(student);
    }
    @GetMapping("/getStudents")
    public List<Student> getStudents(){
        return service.retrieveStudents();
    }
    @DeleteMapping("/student/{studentId}")
    Map<String, String> removeStudent(@PathVariable  Long studentId){
        boolean removeStudent = service.removeStudent(studentId);

        if (removeStudent){
            return Collections.singletonMap("status","removed Student");
        }else {
            return Collections.singletonMap("status","failed");
        }
    }
}
