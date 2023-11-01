package com.example.travelAgency.guideService.controller;

import com.example.travelAgency.guideService.bo.GuideBO;
import com.example.travelAgency.guideService.dto.GuideDTO;
import com.example.travelAgency.guideService.dto.ResponseDTO;
import com.example.travelAgency.guideService.util.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/guide")
@CrossOrigin
public class GuideController {

    private final GuideBO guideBO;

    @Autowired
    public GuideController(GuideBO guideBO) {
        this.guideBO = guideBO;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseUtil<GuideDTO> saveGuide(@ModelAttribute @Valid GuideDTO guideDTO) throws IOException {
        guideBO.saveGuide(guideDTO);
        return new ResponseUtil<GuideDTO>(201, "Saved", null);
    }

    @PutMapping
    public ResponseUtil updateGuide(@ModelAttribute @Valid GuideDTO guideDTO) {
        guideBO.updateGuide(guideDTO);
        return new ResponseUtil(200, "Guide Updated..!", null);
    }

    @DeleteMapping(path = "{/guideName}")
    public ResponseUtil<GuideDTO> deleteGuide(@PathVariable("guideName") String name) {
        guideBO.deleteGuide(name);
        return new ResponseUtil(200, "Guide Deleted...!", null);
    }

    @GetMapping(path = "{/guideName}")
    public boolean isExistGuideByGuideName(@RequestParam("guideName") String name) {
        return guideBO.isExistGuideByGuideName(name);
    }

    @GetMapping
    public ResponseUtil<List<ResponseDTO>> getAllGuides(){
        return new ResponseUtil<>(200,"Ok",guideBO.getAllGuides());
    }
}
