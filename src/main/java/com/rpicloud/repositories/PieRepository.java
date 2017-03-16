package com.rpicloud.repositories;

import com.rpicloud.models.Pie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tharindu on 3/15/17.
 */
//public interface PieRepository extends CrudRepository <Pie, Long> {
@Repository
public interface PieRepository extends JpaRepository<Pie, Long> {
    List<Pie> findByName(String name);
    List<Pie> findByDescription(String description);
    List<Pie> findByAge(int age);
}
