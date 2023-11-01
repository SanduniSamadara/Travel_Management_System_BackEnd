package com.example.travelAgency.userService.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class ResponseDTO {
    private long userId;
    private String userName;
    private String password;
    private String role;
    private String user_nic_image_front_view;
    private String user_nic_image_rare_view;
    private String gender;
    private String email;
    private String contact;
    private String remarks;

}
