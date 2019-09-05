package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DriverModel;

@Repository
public interface DriverRepository extends JpaRepository<DriverModel, Long>{

}
