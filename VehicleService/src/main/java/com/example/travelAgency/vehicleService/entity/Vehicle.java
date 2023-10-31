package com.example.travelAgency.vehicleService.entity;

import jakarta.persistence.*;
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
public class Vehicle implements Super{

    @Id
    @GeneratedValue
    private String vehicleId;
    @NotBlank(message = "Vehicle Brand shouldn't be blank")
    private String brand;
    @NotEmpty(message = "Hybrid or not shouldn't be empty")
    private boolean isHybrid;
    @NotEmpty(message = "Seat Capacity shouldn't be empty")
    private int seatCapacity;
    @NotEmpty(message = "vehicle Type shouldn't be empty")
    private String vehicleType;
    @NotEmpty(message = "Vehicle Image shouldn't be empty")
    private byte[] ImagesVehicle;
    @NotEmpty(message = "TransmissionType shouldn't be empty")
    private String transmissionType;
    @NotEmpty(message = "Fuel Usage shouldn't be empty")
    @Min(value = 1, message = "fuel Usage shouldn't be less than 1")
    @Max(value = 200, message = "fuel Usage shouldn't be greater than 100")
    private int fuelUsage;
    @NotEmpty(message = "FuelType shouldn't be empty")
    private String fuelType;
    @NotEmpty(message = "Remarks shouldn't be empty")
    private String remarks;
    @NotEmpty(message = "Driver Name shouldn't be empty")
    private String driverName;
    @NotEmpty(message = "Driver Contact shouldn't be empty")
    private String driverContact;
    @NotEmpty(message = "Driver License Image shouldn't be empty")
    private byte[] driver_license_image;
    @ManyToOne
    private VehicleCategory vehicleCategory;

}
