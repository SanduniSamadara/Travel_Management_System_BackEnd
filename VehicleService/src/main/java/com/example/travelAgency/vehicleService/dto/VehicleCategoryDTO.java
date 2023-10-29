package com.example.travelAgency.vehicleService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VehicleCategoryDTO {
    private String vehicle_category_id;
    private String regular;
    private String midLevel;
    private String luxury;
    private String superLuxury;
}
