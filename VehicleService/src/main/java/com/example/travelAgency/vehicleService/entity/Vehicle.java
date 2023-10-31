package com.example.travelAgency.vehicleService.entity;

import jakarta.persistence.*;
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
    private String brand;
    private boolean isHybrid;
    private int seatCapacity;
    private String vehicleType;
    @Embedded
    private Image image;
    private String transmissionType;
    private int fuelUsage;
    private String fuelType;
    private String remarks;
    private String driverName;
    private String driverContact;
    private byte[] driver_license_image;
    @ManyToOne
    private VehicleCategory vehicleCategory;

}
