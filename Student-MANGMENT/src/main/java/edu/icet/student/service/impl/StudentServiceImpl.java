package edu.icet.student.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.student.dto.Student;
import edu.icet.student.entity.StudentEntity;
import edu.icet.student.repository.StudentRepository;
import edu.icet.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;
    @Autowired
    ObjectMapper objectMapper;
    @Override
    public StudentEntity createStudent(Student student) {
        StudentEntity entity =  objectMapper.convertValue(student, StudentEntity.class);
            return repository.save(entity);
    }

    @Override
    public List<Student> retrieveStudents() {
        List<Student> list = new ArrayList<>();
        Iterable<StudentEntity> studentList = repository.findAll();
        Iterator<StudentEntity> iterator = studentList.iterator();

        while (iterator.hasNext()){
            StudentEntity entity = iterator.next();
            Student student = objectMapper.convertValue(entity, Student.class);
            list.add(student);
        }
        return list;
    }

    @Override
    public boolean removeStudent(Long studentId) {
        Optional<StudentEntity> byId = repository.findById(studentId);
        if (byId.isPresent()){
            repository.deleteById(studentId);
            return true;
        }
        return false;
    }


}
