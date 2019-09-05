package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CarModel;
import com.example.demo.repos.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepo;
	
	public CarModel save(CarModel entity) {
		return carRepo.save(entity);
	}

	public Iterable<CarModel> findAll() {
		return carRepo.findAll();
	}
	

	public CarModel findById(long id) {
		
		return carRepo.findById(id).get();
	}
	
	public void deleteCarById(Long id) throws IllegalArgumentException{
	
		carRepo.deleteById(id);
	}
	
}
