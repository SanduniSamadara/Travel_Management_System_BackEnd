package com.example.travelAgency.guideService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GuideDTO {
    private String guideId;
    private String name;
    private String address;
    private String experience;
    private byte[] image;
    private NicImageDTO guide_nic_image;
    private GuideIdDTO guide_id_image;
    private String gender;
    private String remarks;
    private String contact;
    private int manDayValues;

}
