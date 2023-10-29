package com.example.travelAgency.userService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ImageDTO {
    private byte[] front_view;
    private byte[] rear_view;
}
