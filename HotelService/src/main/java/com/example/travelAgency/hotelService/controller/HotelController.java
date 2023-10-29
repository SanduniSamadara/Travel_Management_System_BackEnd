package com.example.travelAgency.hotelService.controller;

import com.example.travelAgency.hotelService.bo.HotelBO;
import com.example.travelAgency.hotelService.dto.HotelDTO;
import com.example.travelAgency.hotelService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hotel")
public class HotelController {

    @Autowired
    HotelBO hotelBO;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveHotel(HotelDTO hotelDTO) {
        hotelBO.saveHotel(hotelDTO);
        return new ResponseUtil(200, "Hotel Added..!", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateHotel(HotelDTO hotelDTO) {
       hotelBO.updateHotel(hotelDTO);
        return new ResponseUtil(200, "Hotel Updated..!", null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteHotel(String id) {
        hotelBO.deleteHotel(id);
        return new ResponseUtil(200,"Hotel Deleted...!",null);
    }

    @GetMapping(path = "/{hotelId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchHotel(@PathVariable String hotelId){
        return new ResponseUtil(200,"Ok",hotelBO.searchHotel(hotelId));
    }

    @GetMapping(produces = "application/json")
    public ResponseUtil getAllHotels() {
        return new ResponseUtil(200,"Ok",hotelBO.getAllHotels());
    }
}
