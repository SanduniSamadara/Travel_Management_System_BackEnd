package com.example.travelAgency.vehicleService.bo;

import com.example.travelAgency.vehicleService.dto.VehicleDTO;

import java.util.List;

public interface VehicleBO {
    public void saveVehicle(VehicleDTO vehicleDTO);

    public void updateVehicle(VehicleDTO vehicleDTO);

    public VehicleDTO searchVehicle(String id);

    public void deleteVehicle(String id);

    public List<VehicleDTO> getAllVehicles();
}
