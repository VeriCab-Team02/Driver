package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DriverModel;

@Repository
public interface DriverRepository extends CrudRepository<DriverModel, Long>{

}
