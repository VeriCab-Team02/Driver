package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component 
@Entity 
@Table(name="vericab_location")
public class CurrentLocation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;
	
	private Double latitude;
	private Double	 longitude;
	
}
