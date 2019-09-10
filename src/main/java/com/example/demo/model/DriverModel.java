package com.example.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component 
@Entity 
@Table(name="vericab_driver")
public class DriverModel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;

    @NotNull
    private String name;  //First name+Last name
    private String gender;  //To be entered as 'Male, 'Female', 'Transgender' only
    private Double rating;   //On a scale of 5
    private Integer totalNoOfRatings;
    
    @NotEmpty 
    @Email
    private String email; 
    
    @NotNull(message = "Phone Number can not be empty..!")
    @Pattern(regexp="([0-9]{10})")
    private String phoneNumber;
    
    @DateTimeFormat(pattern="MM/dd/yyyy")
    @Past(message = "Date is not ..!")
    private Date dob;
    
    @Column(nullable = false)
    @Size(min=6, max=30)
    @NotNull(message = "Username can not be null..!")
    private String username;

    @Column(nullable = false)
    @NotNull(message = "Password can not be null..!")
    private String password;
    
    private String driverPhotoLocation;
    
    @NotEmpty
    private String licenseNumber; //Eg. MH-4089503248
    
}
