package com.example.travelAgency.vehicleService.repository;

import com.example.travelAgency.vehicleService.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepo extends JpaRepository<Vehicle,String> {
}
