package com.example.travelAgency.travelService.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Travel implements Super {

    @Id
    @GeneratedValue
    private String packageId;
    private String hotelId;
    private String guideId;
    private String userId;
    private String vehicleId;

    @NotNull(message = "TravelArea shouldn't be null")
    private String travelArea;
    @NotEmpty(message = "Guidance presence shouldn't be empty")
    private boolean guidePresence;
    @NotEmpty(message = "Are pets allowed shouldn't be empty")
    private boolean isPetAllowed;
    @NotEmpty(message = " paid Value shouldn't be empty")
    @Min(value = 0, message = "paid Value shouldn't be less than 0")
    private double paidValue;
    @NotEmpty(message = " User's NIC images BackEnd shouldn't be empty")
    private byte[] userNIC_images;

    @Embedded
    private Package packageValue;
    @Embedded
    private Duration travelDuration;

    @NotEmpty(message = " Remarks shouldn't be empty")
    private String remarks;
    @NotEmpty(message = " Adult count shouldn't be empty")
    @Min(value = 1, message = "Adult count shouldn't be less than 1")
    private int adults;
    @NotEmpty(message = " Child count shouldn't be empty")
    @Min(value = 1, message = "Child count shouldn't be less than 1")
    private int children;
    @NotEmpty(message = " Adult count shouldn't be empty")
    @Min(value = 1, message = "Adult count shouldn't be less than 1")
    private int headCounts;

}
