package com.example.travelAgency.vehicleService.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Embeddable
@Table(name = "image")
public class Image {
    private byte[] front_view;
    private byte[] rear_view;
    private byte[] side_view;
    private byte[] front_interior;
    private byte[] rear_interior;
}
