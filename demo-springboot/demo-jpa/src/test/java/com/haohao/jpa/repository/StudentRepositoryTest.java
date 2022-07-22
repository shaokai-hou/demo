package com.haohao.jpa.repository;

import com.haohao.jpa.entity.StudentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void insert() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName("张三");
        studentEntity.setAge(18);
        studentRepository.save(studentEntity);
    }

    @Test
    void list() {
        List<StudentEntity> students = studentRepository.findAll();
        students.forEach(System.err::println);
    }

    @Test
    void delete() {
        studentRepository.deleteById(1);
    }

}