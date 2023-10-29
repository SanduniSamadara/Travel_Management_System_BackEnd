package com.example.travelAgency.guideService.bo.boImpl;

import com.example.travelAgency.guideService.dto.GuideDTO;
import com.example.travelAgency.guideService.entity.Guide;
import com.example.travelAgency.guideService.repository.GuideRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class GuideBOImpl {
    private final GuideRepo guideRepo;

    public void saveGuide(GuideDTO guideDTO, Object guideIdDTO) {
        Guide guide = Guide.builder()
                .name(guideDTO.getName())
                .address(guideDTO.getAddress())
                .experience(guideDTO.getAddress())
                .gender(guideDTO.getGender())
                .remarks(guideDTO.getRemarks())
                .contact(guideDTO.getContact())
                .manDayValues(guideDTO.getManDayValues())
                .build();

        guideRepo.save(guide);
        log.info("Guide is Saved", guide.getGuideId());

    }


    public void updateGuide(GuideDTO guideDTO, Object guideIdDTO) {
        Guide guide = Guide.builder()
                .name(guideDTO.getName())
                .address(guideDTO.getAddress())
                .experience(guideDTO.getAddress())
                .gender(guideDTO.getGender())
                .remarks(guideDTO.getRemarks())
                .contact(guideDTO.getContact())
                .manDayValues(guideDTO.getManDayValues())
                .build();

        guideRepo.save(guide);
        log.info("Guide is Updated", guide.getGuideId());

    }


    public GuideDTO searchGuide(String id) {
        return null;
    }

    public void deleteGuide(String id) {

    }

    public List<Guide> getAllGuides() {
        List<Guide> all = guideRepo.findAll();
        return all.stream().unordered().map(this::mapToGuide).toList();
    }

    private  Guide mapToGuide(Guide guide) {
        return Guide.builder()
                .guideId(guide.getGuideId())
                .name(guide.getName())
                .address(guide.getAddress())
                .experience(guide.getAddress())
                .gender(guide.getGender())
                .remarks(guide.getRemarks())
                .contact(guide.getContact())
                .manDayValues(guide.getManDayValues())
                .build();

    }
}


