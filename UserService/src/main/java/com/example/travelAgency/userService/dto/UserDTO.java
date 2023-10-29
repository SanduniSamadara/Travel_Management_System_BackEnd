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
    private String name;
    private String password;
    private String role;
    private String nic;
    private ImageDTO user_nic_image;
    private String gender;
    private String email;
    private String contact;
}
