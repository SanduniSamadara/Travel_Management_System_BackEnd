package com.example.travelAgency.guideService.util;

import com.example.travelAgency.guideService.dto.GuideDTO;
import com.example.travelAgency.guideService.entity.Guide;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConversion {
    private final ModelMapper modelMapper;

    public EntityDTOConversion(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Guide getGuideEntity(GuideDTO guideDTO) {
        return modelMapper.map(guideDTO, Guide.class);
    }

    public GuideDTO getGuideDTO(Guide guide) {
        return modelMapper.map(guide, GuideDTO.class);
    }
}