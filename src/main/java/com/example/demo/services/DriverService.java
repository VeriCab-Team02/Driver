package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DriverModel;
import com.example.demo.repos.DriverRepository;


@Service
public class DriverService {
	
	@Autowired
	private DriverRepository repo;
	
	public DriverModel save(DriverModel entity) {
		return repo.save(entity);
	}

	public Iterable<DriverModel> findAll() {
		return repo.findAll();
	}
	
	
}
