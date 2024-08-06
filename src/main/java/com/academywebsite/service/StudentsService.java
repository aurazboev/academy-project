package com.academywebsite.service;

import com.academywebsite.documents.Students;
import com.academywebsite.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {
    @Autowired
    StudentsRepository studentsRepository;


    public List<Students> getAllStudents() {
        return studentsRepository.findAll();
    }

    public Students createStudent(Students student) {
        return studentsRepository.save(student);
    }

    public Students updateStudent(String id, Students student) {
        student.setId(id);
        return studentsRepository.save(student);
    }

    public void deleteStudent(String id) {
        studentsRepository.deleteById(id);
    }

    public Students getStudentById(String id) {
        return studentsRepository.findById(id).get();
    }
}
