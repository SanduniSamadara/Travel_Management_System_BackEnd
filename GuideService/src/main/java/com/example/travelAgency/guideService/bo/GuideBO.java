package com.example.travelAgency.guideService.bo;

import com.example.travelAgency.guideService.dto.GuideDTO;
import com.example.travelAgency.guideService.dto.ResponseDTO;

import java.util.List;

public interface GuideBO {
    public void updateGuide(GuideDTO guideDTO);

    public GuideDTO searchGuide(String id);

    public void deleteGuide(String userName);

    public List<ResponseDTO> getAllGuides();

    boolean isExistGuideByGuideName(String name);

    void saveGuide(GuideDTO guideDTO);
}
