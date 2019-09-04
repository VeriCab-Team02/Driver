package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CarModel;
import com.example.demo.repos.CarRepository;


@Service
public class CarService {
	
	@Autowired
	private CarRepository repo;
	
	public CarModel save(CarModel entity) {
		return repo.save(entity);
	}

	public Iterable<CarModel> findAll() {
		return repo.findAll();
	}
	
	
}
