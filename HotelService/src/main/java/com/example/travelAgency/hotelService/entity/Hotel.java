package com.example.travelAgency.hotelService.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Hotel {

    @Id
    @GeneratedValue
    private Long hotelId;
    @NotNull(message = "Hotel name shouldn't be null")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$" , message ="Invalid name")
    private String name;
    @NotEmpty(message = "Are pets allowed shouldn't be empty")
    private boolean isPetAllowed;
    @NotEmpty(message = "Location shouldn't be empty")
    private String location;
    @NotEmpty(message = "Hotel Fee shouldn't be empty")
    @Negative(message = " Hotel Fee shouldn't be empty")
    @Min(value = 0, message = "Hotel Fee shouldn't be less than 0")
    private double hotelFee;
    @Email(message = "Invalid email address")
    @Pattern(regexp ="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$" , message = "Invalid email address")
    private String email;
    @NotEmpty(message = "Remarks shouldn't be empty")
    private String remarks;
    @Embedded
    private Contact contact;

}
