package com.example.travelAgency.travelService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PackageDTO {
    private double hotel_fee_per_days;
    private double vehicle_fee_per_days;
    private double guide_fee_per_days;
}
