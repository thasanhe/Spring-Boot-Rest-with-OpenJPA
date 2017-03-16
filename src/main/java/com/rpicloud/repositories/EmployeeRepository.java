package com.rpicloud.repositories;

import com.rpicloud.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tharindu on 3/15/17.
 */
//public interface PieRepository extends CrudRepository <Pie, Long> {
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    List<Employee> findByName(String name);
}
