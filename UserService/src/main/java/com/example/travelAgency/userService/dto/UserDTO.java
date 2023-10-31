package com.example.travelAgency.userService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDTO {
    private String userId;
    private String userName;
    private String password;
    private String role;
    private byte[] user_nic_image_front_view;
    private byte[] user_nic_image_rare_view;
    private String gender;
    private String email;
    private String contact;
    private String remarks;

}
