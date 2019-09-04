package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CarModel;

@Repository
public interface CarRepository extends CrudRepository<CarModel, Long>{

}
