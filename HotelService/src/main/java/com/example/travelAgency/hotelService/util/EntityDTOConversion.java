package com.example.travelAgency.hotelService.util;

import com.example.travelAgency.hotelService.dto.HotelDTO;
import com.example.travelAgency.hotelService.entity.Hotel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConversion {
    private final ModelMapper modelMapper;

    public EntityDTOConversion(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Hotel getHotelEntity(HotelDTO hotelDTO) {
        return modelMapper.map(hotelDTO, Hotel.class);
    }

    public HotelDTO getHotelDTO(Hotel hotel) {
        return modelMapper.map(hotel, HotelDTO.class);
    }
}