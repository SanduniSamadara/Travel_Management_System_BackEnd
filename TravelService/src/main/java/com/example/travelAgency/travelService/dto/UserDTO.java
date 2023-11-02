package com.example.travelAgency.travelService.dto;

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
public class UserDTO {
    @Min(value = 1, message = "User id cannot less than 1")
    @NotBlank(message = "User Id cannot be blank")
    private long userId;
    @NotBlank(message = "Name cannot be blank")
    private String userName;
    @NotBlank(message = "Password cannot be blank")
    private String password;
    @NotBlank(message = "Role cannot be blank")
    private String role;
    @NotBlank(message = "NIC front view cannot be blank")
    private MultipartFile user_nic_image_front_view;
    @NotBlank(message = "NIC rare view cannot be blank")
    private MultipartFile user_nic_image_rare_view;
    @NotBlank(message = "Gender cannot be blank")
    private String gender;
    @NotBlank(message = "Email cannot be blank")
    private String email;
    @NotBlank(message = "Contact No cannot be blank")
    private String contact;
    @NotBlank(message = "Remarks cannot be blank")
    private String remarks;

}
