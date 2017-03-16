package com.rpicloud.controllers;

import com.rpicloud.models.CarHireEvent;
import com.rpicloud.repositories.CarHireEventRepository;
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
@RequestMapping("/carhire")
public class CarHireEventRestController {

    @Autowired
    private CarHireEventRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<CarHireEvent>> getAllCarHireEvents() {
        return new ResponseEntity<>((Collection<CarHireEvent>) repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"equipInitial"})
    public ResponseEntity<Collection<CarHireEvent>> findStudentWithName(@RequestParam(value = "equipInitial") String equipInitial) {
        return new ResponseEntity<>(repository.findByEquipInitial(equipInitial), HttpStatus.OK);
    }
}
