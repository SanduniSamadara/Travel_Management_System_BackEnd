package com.example.travelAgency.vehicleService.controller;

import com.example.travelAgency.vehicleService.bo.VehicleBO;
import com.example.travelAgency.vehicleService.dto.VehicleDTO;
import com.example.travelAgency.vehicleService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/vehicle")
@CrossOrigin
public class VehicleController {

    @Autowired
    VehicleBO vehicleBO;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveVehicle(VehicleDTO vehicleDTO) {
        vehicleBO.saveVehicle(vehicleDTO);
        return new ResponseUtil(200, "Vehicle Added..!", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateVehicle(VehicleDTO vehicleDTO) {
       vehicleBO.updateVehicle(vehicleDTO);
        return new ResponseUtil(200, "Vehicle Updated..!", null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteVehicle(String id) {
        vehicleBO.deleteVehicle(id);
        return new ResponseUtil(200,"Vehicle Deleted...!",null);
    }

    @GetMapping(path = "/{vehicleId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchVehicle(@PathVariable String vehicleId){
        return new ResponseUtil(200,"Ok",vehicleBO.searchVehicle(vehicleId));
    }

    @GetMapping(produces = "application/json")
    public ResponseUtil getAllVehicles() {
        return new ResponseUtil(200,"Ok",vehicleBO.getAllVehicles());
    }
}

