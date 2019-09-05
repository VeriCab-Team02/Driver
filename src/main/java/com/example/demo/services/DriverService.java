package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DriverModel;
import com.example.demo.repos.DriverRepository;


@Service
public class DriverService {
	
	@Autowired
	private DriverRepository driverRepo;
	
	public DriverModel save(DriverModel entity) {
		return driverRepo.save(entity);
	}

	public Iterable<DriverModel> findAll() {
		return driverRepo.findAll();
	}

	public DriverModel findById(long id) {
		
		return driverRepo.findById(id).get();
	}
	
	public void deleteDriverById(Long id) throws IllegalArgumentException{
	
		driverRepo.deleteById(id);
	}
}
