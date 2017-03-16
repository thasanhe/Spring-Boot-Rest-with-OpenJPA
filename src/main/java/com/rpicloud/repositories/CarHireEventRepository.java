package com.rpicloud.repositories;

import com.rpicloud.models.CarHireEvent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by tharindu on 3/16/17.
 */
public interface CarHireEventRepository extends CrudRepository<CarHireEvent, Integer>{
    List<CarHireEvent> findByEquipInitial(String equipInitial);
}
