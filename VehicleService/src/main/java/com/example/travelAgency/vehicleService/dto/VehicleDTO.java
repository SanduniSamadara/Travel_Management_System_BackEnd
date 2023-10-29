package com.example.travelAgency.vehicleService.dto;

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
    private ImageDTO image;
    private String transmissionType;
    private int fuelUsage;
    private String fuelType;
    private String remarks;
    private String driverName;
    private String driverContact;
    private byte[] driver_license_image;
    private String vehicle_category_id;

}
