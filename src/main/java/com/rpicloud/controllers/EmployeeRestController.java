package com.rpicloud.controllers;

import com.rpicloud.models.Employee;
import com.rpicloud.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by tharindu on 3/15/17.
 */
@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

    @Autowired
    private EmployeeRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Employee>> getAllEmployees() {
        return new ResponseEntity<>((Collection<Employee>) repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name"})
    public ResponseEntity<Collection<Employee>> findEmployeeWithName(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
    }


   /* @RequestMapping(method = RequestMethod.GET, params = {"name"})
    public ResponseEntity<Collection<Employee>> findPieWithName(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"description"})
    public ResponseEntity<Collection<Employee>> findEmployeeWithDescription(@RequestParam(value = "description") String description) {
        return new ResponseEntity<>(repository.findByDescription(description), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"age"})
    public ResponseEntity<Collection<Employee>> findEmployeeWithAge(@RequestParam(value = "age") int age) {
        return new ResponseEntity<>(repository.findByAge(age), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addEmployee(@RequestBody Employee input) {
        return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
    }*/
}
