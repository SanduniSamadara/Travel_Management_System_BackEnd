package com.example.travelAgency.guideService.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ResponseDTO {
    private long guideId;
    private String name;
    private String address;
    private String experience;
    private String guide_nic_image_front_view;
    private String guide_nic_image_rare_view;
    private String guide_id_image_front_view;
    private String guide_id_image_rare_view;
    private String gender;
    private String remarks;
    private String contact;
    private int manDayValues;
}
