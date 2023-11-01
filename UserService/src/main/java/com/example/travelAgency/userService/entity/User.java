package com.example.travelAgency.userService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@Document
public class User implements Super {
    @Id
    @GeneratedValue
    private long userId;
    @NotNull(message = "Username shouldn't be null")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$", message = "Invalid username")
    private String userName;
    @NotNull(message = "Password shouldn't be null")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+\\.[a-zA-Z]{2,}$", message = "Invalid password")
    private String password;
    @NotNull(message = "Role shouldn't be null")
    @Pattern(message = "Role should be user or admin",
            regexp = "^(user|admin)$")
    private String role;
    @NotEmpty(message = "User's NIC front side Images shouldn't be empty")
    private String user_nic_image_front_view;
    @NotEmpty(message = "User's NIC rare side image shouldn't be empty")
    private String user_nic_image_rare_view;
    @NotEmpty(message = "Gender shouldn't be empty")
    private String gender;
    @Email(message = "Invalid email address")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid Email address")
    private String email;
    private String contact;
    @NotEmpty(message = "Remarks shouldn't be empty")
    private String remarks;


}
