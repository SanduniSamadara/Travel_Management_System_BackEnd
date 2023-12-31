package com.example.travelAgency.guideService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Document
public class Guide implements Super{
    @Id
    private long guideId;
    @NotNull(message = "Guide name shouldn't be null")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$" , message ="Invalid name")
    private String guideName;
    @NotNull(message = "Guide address shouldn't be null")
    @Pattern(regexp = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$" , message ="Invalid address")
    private String address;
    @NotEmpty(message = "Experience shouldn't be empty")
    private String experience;
    @NotEmpty(message = "Guide's NIC images shouldn't be empty")
    private String guide_nic_image_front_view;
    @NotEmpty(message = "Guide's NIC images shouldn't be empty")
    private String guide_nic_image_rare_view;
    @NotEmpty(message = "Guide's Id images shouldn't be empty")
    private String guide_id_image_front_view;
    @NotEmpty(message = "Guide's Id images shouldn't be empty")
    private String guide_id_image_rare_view;
    @NotEmpty(message = "Gender shouldn't be empty")
    private String gender;
    @NotEmpty(message = "Remarks shouldn't be empty")
    private String remarks;
    @NotBlank(message = "Contact No shouldn't be blank")
    @Pattern(regexp ="^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$" , message = "Invalid contact number")
    private String contact;
    @NotEmpty(message = "Man day value shouldn't be empty")
    @Min(value = 0, message = "Man day value shouldn't be less than 0")
    private int manDayValues;
}
