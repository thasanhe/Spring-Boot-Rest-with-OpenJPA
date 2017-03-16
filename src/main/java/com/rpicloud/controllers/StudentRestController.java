package com.rpicloud.controllers;

import com.rpicloud.models.Student;
import com.rpicloud.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by tharindu on 3/16/17.
 */
@RestController
@RequestMapping("/students")
public class StudentRestController {
    @Autowired
    private StudentRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Student>> getAllStudents() {
        return new ResponseEntity<>((Collection<Student>) repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name"})
    public ResponseEntity<Collection<Student>> findStudentWithName(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
    }
}

