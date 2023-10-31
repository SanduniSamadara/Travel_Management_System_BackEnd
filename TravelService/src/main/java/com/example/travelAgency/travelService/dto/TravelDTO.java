package com.example.travelAgency.travelService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TravelDTO {
    private String packageId;
    private String hotelId;
    private String guideId;
    private String userId;
    private String vehicleId;
    private String travelArea;
    private boolean guidePresence;
    private boolean isPetAllowed;
    private double paidValue;
    private byte[] userNIC_images;
    private PackageDTO packageValue;
    private DurationDTO travelDuration;
    private String remarks;
    private int adults;
    private int children;
    private int headCounts;

}
