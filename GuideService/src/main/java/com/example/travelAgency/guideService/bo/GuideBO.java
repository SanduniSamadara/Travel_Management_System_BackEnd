package com.example.travelAgency.guideService.bo;

import com.example.travelAgency.guideService.dto.GuideDTO;

import java.util.List;

public interface GuideBO {
    public void saveGuide(GuideDTO guideDTO, Object guideIdDTO);

    public void updateGuide(GuideDTO guideDTO);

    public GuideDTO searchGuide(String id);

    public void deleteGuide(String id);

    public List<GuideDTO> getAllGuides();
}
