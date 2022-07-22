package com.haohao.jpa.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.haohao.jpa.entity.StudentEntity;
import com.haohao.jpa.repository.StudentRepository;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author haohao
 * @date 2022年07月22日 12:00
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentRepository studentRepository;

    @PostMapping
    @SneakyThrows
    public String save(@RequestBody StudentEntity studentEntity) {
        return new ObjectMapper().writeValueAsString(studentRepository.save(studentEntity));
    }

    @GetMapping
    @SneakyThrows
    public String list() {
        List<StudentEntity> all = studentRepository.findAll();
        return new ObjectMapper().writeValueAsString(all);
    }

    @DeleteMapping("/{id}")
    @SneakyThrows
    public void delete(@PathVariable("id") Integer id) {
        studentRepository.deleteById(id);
    }
}
