package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
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
@Table("vericab_driver")
public class DriverModel {

    @PrimaryKey
    private Long id;

    @NotNull
    private String name;  //First name+Last name
    private String gender;  //To be entered as 'Male, 'Female', 'Transgender' only
    private Double rating;   //On a scale of 5
    
    @NotEmpty 
    @Email
    private String email; 
    
    @NotEmpty(message = "Phone Number can not be empty..!")
    private Long phoneNumber;
    
    @DateTimeFormat(pattern="MM/dd/yyyy") 
    @NotNull 
    @Past
    private Date dob;
    
    @Column(nullable = false)
    @Size(min=6, max=30)
    @NotNull(message = "Username can not be null..!")
    private String username;

    @Column(nullable = false)
    @NotNull(message = "Password can not be null..!")
    private String password;
    
    @NotNull
    private String driverPhotoLocation;
    
    @NotEmpty
    private String licenseNumber; //Eg. MH-4089503248
}
