package com.example.travelAgency.guideService.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class GuideDTO {
    private long guideId;
    private String name;
    private String address;
    private String experience;
    private MultipartFile guide_nic_image_front_view;
    private MultipartFile guide_nic_image_rare_view;
    private MultipartFile guide_id_image_front_view;
    private MultipartFile guide_id_image_rare_view;
    private String gender;
    private String remarks;
    private String contact;
    private int manDayValues;

}
