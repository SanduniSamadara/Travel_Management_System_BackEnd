package com.example.travelAgency.travelService.controller;

import com.example.travelAgency.travelService.bo.TravelBO;
import com.example.travelAgency.travelService.dto.TravelDTO;
import com.example.travelAgency.travelService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/travel")
@CrossOrigin
public class TravelController {


    TravelBO travelBO;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveTravel(TravelDTO travelDTO) {
        travelBO.saveTravel(travelDTO);
        return new ResponseUtil(200, "Travel Package Added..!", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateTravel(TravelDTO travelDTO) {
        travelBO.updateTravel(travelDTO);
        return new ResponseUtil(200, "Travel package Updated..!", null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteTravel(String id) {
        travelBO.deleteTravel(id);
        return new ResponseUtil(200,"Travel Package Deleted...!",null);
    }

    @GetMapping(path = "/{packageId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchUser(@PathVariable String packageId){
        return new ResponseUtil(200,"Ok",travelBO.searchTravel(packageId));
    }

    @GetMapping(produces = "application/json")
    public ResponseUtil getAllTravel() {
        return new ResponseUtil(200,"Ok",travelBO.getAllTravel());

    }
}

