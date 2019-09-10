package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CarModel;

@Repository
public interface CarRepository extends JpaRepository<CarModel, Long>{

	Iterable<CarModel> findByType(String type);

}
