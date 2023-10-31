package com.example.travelAgency.vehicleService.dto;

import com.example.travelAgency.vehicleService.entity.VehicleCategory;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VehicleDTO {
    private String vehicleId;
    private String brand;
    private boolean isHybrid;
    private int seatCapacity;
    private String vehicleType;
    private byte[] ImagesVehicle;
    private String transmissionType;
    private int fuelUsage;
    private String fuelType;
    private String remarks;
    private String driverName;
    private String driverContact;
    private byte[] driver_license_image;
    private VehicleCategory vehicle_category_id;

}
