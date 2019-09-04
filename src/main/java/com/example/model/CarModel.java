package com.example.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
@Table("vericab_car")
public class CarModel {

	@PrimaryKey
    private Long id;
	
	private String manufacturer;  //Eg. Toyota
	private String variant;  //Eg. Corolla variant of Toyota
	
	@Size(min=10, max=15)
	private String registrationNumber;  //Eg. TN 27 CT 0595
	private Integer noOfSeaters;	//4 , 6 seaters
	private String type; //Hatchback or Sedan class
	
	@NotEmpty
	private Double ratePerKm;
	
//	@OneToOne(cascade = CascadeType.ALL)
//  @JoinColumn(name = "geoLocation", referencedColumnName = "id")
//	private CurrentLocation location;
}