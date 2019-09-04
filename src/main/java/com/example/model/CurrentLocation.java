package com.example.model;

import javax.persistence.Entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component 
@Entity 
@Table("vericab_location")
public class CurrentLocation {

	@PrimaryKey
    private Long id;
	
	private Double latitude;
	private Double	 longitude;
	
}
