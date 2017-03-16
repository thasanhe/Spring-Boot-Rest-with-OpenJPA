package com.rpicloud.repositories;

import com.rpicloud.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by tharindu on 3/16/17.
 */
public interface StudentRepository extends CrudRepository<Student, Integer>{
    List<Student> findByName(String name);
}
