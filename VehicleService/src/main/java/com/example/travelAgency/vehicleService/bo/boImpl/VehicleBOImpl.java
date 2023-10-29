package com.example.travelAgency.vehicleService.bo.boImpl;

import com.example.travelAgency.vehicleService.bo.VehicleBO;
import com.example.travelAgency.vehicleService.dto.VehicleDTO;
import com.example.travelAgency.vehicleService.entity.Vehicle;
import com.example.travelAgency.vehicleService.repository.VehicleRepo;
import com.example.travelAgency.vehicleService.util.EntityDTOConversion;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VehicleBOImpl implements VehicleBO {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private EntityDTOConversion conversion;


    @Override
    public void updateVehicle(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getVehicleId())) {
            vehicleRepo.save(conversion.getVehicleEntity(vehicleDTO));
        }
    }

    @Override
    public void saveVehicle(VehicleDTO vehicleDTO) {
        if (!vehicleRepo.existsById(vehicleDTO.getVehicleId())) {
            vehicleRepo.save(conversion.getVehicleEntity(vehicleDTO));
        }
    }

    @Override
    public VehicleDTO searchVehicle(String id) {
        if (vehicleRepo.existsById(id)) {
            Vehicle vehicle = vehicleRepo.findById(id).get();
            return conversion.getVehicleDTO(vehicle);
        }
        return null;
    }

    @Override
    public void deleteVehicle(String id) {
        if (vehicleRepo.existsById(id)) {
            vehicleRepo.deleteById(id);
        }
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return modelMapper.map(vehicleRepo.findAll(), new TypeToken<List<VehicleDTO>>() {}.getType());
    }
}
