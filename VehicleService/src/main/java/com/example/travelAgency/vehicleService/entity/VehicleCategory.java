package com.example.travelAgency.vehicleService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VehicleCategory {
    @Id
    private String vehicle_category_id;
    private String regular;
    private String midLevel;
    private String luxury;
    private String superLuxury;
    @OneToMany(mappedBy = "vehicleCategory",cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

}
