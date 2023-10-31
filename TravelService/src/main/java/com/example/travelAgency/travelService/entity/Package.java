package com.example.travelAgency.travelService.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Embeddable
@Table(name = "package")
public class Package {
    @NotEmpty(message = "Hotel Fee shouldn't be empty")
    @Min(value = 0, message = "Hotel Fee shouldn't be less than 0")
    private double hotel_fee_per_days;
    @NotEmpty(message = "Vehicle Fee shouldn't be empty")
    @Min(value = 0, message = "Vehicle Fee shouldn't be less than 0")
    private double vehicle_fee_per_days;
    @NotEmpty(message = "Guide Fee shouldn't be empty")
    @Min(value = 0, message = "Guide Fee shouldn't be less than 0")
    private double guide_fee_per_days;

}
