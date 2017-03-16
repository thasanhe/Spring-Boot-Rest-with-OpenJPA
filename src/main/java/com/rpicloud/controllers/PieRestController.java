package com.rpicloud.controllers;

import com.rpicloud.models.Pie;
import com.rpicloud.repositories.PieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by tharindu on 3/15/17.
 */
@RestController
@RequestMapping("/pies")
public class PieRestController {

    @Autowired
    private PieRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Pie>> getAllPies() {
        return new ResponseEntity<>((Collection<Pie>) repository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Pie> getPieWithId (@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"name"})
    public ResponseEntity<Collection<Pie>> findPieWithName(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"description"})
    public ResponseEntity<Collection<Pie>> findPieWithDescription(@RequestParam(value = "description") String description) {
        return new ResponseEntity<>(repository.findByDescription(description), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"age"})
    public ResponseEntity<Collection<Pie>> findPieWithAge(@RequestParam(value = "age") int age) {
        return new ResponseEntity<>(repository.findByAge(age), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addPie(@RequestBody Pie input) {
        return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
    }
}
