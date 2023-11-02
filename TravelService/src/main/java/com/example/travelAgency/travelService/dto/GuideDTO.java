package com.example.travelAgency.guideService.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class GuideDTO {
    @Min(value = 1, message = "Guide id cannot less than 1")
    @NotBlank(message = "Guide Id cannot be blank")
    private long guideId;
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Address cannot be blank")
    private String address;
    @NotBlank(message = "Experience cannot be blank")
    private String experience;
    @NotBlank(message = "NIC front view cannot be blank")
    private MultipartFile guide_nic_image_front_view;
    @NotBlank(message = "NIC rare view cannot be blank")
    private MultipartFile guide_nic_image_rare_view;
    @NotBlank(message = "ID front view cannot be blank")
    private MultipartFile guide_id_image_front_view;
    @NotBlank(message = "ID rare view cannot be blank")
    private MultipartFile guide_id_image_rare_view;
    @NotBlank(message = "Gender cannot be blank")
    private String gender;
    @NotBlank(message = "Remarks cannot be blank")
    private String remarks;
    @NotBlank(message = "Contact No cannot be blank")
    private String contact;
    @NotBlank(message = "Man Day Values cannot be blank")
    private int manDayValues;

}
