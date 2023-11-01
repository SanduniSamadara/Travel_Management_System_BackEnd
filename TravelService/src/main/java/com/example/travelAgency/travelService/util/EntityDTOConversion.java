package com.example.travelAgency.travelService.util;

import com.example.travelAgency.travelService.dto.TravelDTO;
import com.example.travelAgency.travelService.entity.Travel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConversion {
    private final ModelMapper modelMapper;

    public EntityDTOConversion(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Travel getTravelEntity(TravelDTO travelDTO) {
        return modelMapper.map(travelDTO, Travel.class);
    }

    public TravelDTO getTravelDTO(Travel travel) {
        return modelMapper.map(travel, TravelDTO.class);
    }
}