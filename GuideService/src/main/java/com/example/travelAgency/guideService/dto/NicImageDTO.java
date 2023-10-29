package com.example.travelAgency.guideService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class NicImageDTO {
    private byte[] front_view;
    private byte[] rear_view;
}
