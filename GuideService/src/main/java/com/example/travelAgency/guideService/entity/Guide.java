package com.example.travelAgency.guideService.entity;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class Guide {
    @Id
    private String guideId;
    private String name;
    private String address;
    private String experience;
    private byte[] image;
    @Embedded
    private NicImage guide_nic_image;
    @Embedded
    private GuideId guide_id_image;
    private String gender;
    private String remarks;
    private String contact;
    private int manDayValues;
}
