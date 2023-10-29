package com.example.travelAgency.guideService.controller;

import com.example.travelAgency.guideService.bo.GuideBO;
import com.example.travelAgency.guideService.dto.GuideDTO;
import com.example.travelAgency.guideService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/guide")
@CrossOrigin
public class GuideController {

    GuideBO guideBO;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveGuide(GuideDTO guideDTO, Object guideIdDTO) {
        guideBO.saveGuide(guideDTO, guideIdDTO);
        return new ResponseUtil(200, "Guide Added..!", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateGuide(GuideDTO guideDTO) {
        guideBO.updateGuide(guideDTO);
        return new ResponseUtil(200, "Guide Updated..!", null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteGuide(String id) {
        guideBO.deleteGuide(id);
        return new ResponseUtil(200,"Guide Deleted...!",null);
    }

    @GetMapping(path = "/{guideId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchGuide(@PathVariable String guideId){
        return new ResponseUtil(200,"Ok",guideBO.searchGuide(guideId));
    }

    @GetMapping(produces = "application/json")
    public ResponseUtil getAllGuides() {
        return new ResponseUtil(200,"Ok",guideBO.getAllGuides());
    }
}
