package com.example.travelAgency.hotelService.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Hotel {

    @Id
    private Long hotelId;
    private String name;
    private boolean isPetAllowed;
    private String location;
    private String cancellationCriteria;
    private double hotelFee;
    private String locationWithCoordinates;
    private String email;
    private String remarks;
    @Embedded
    private Contact contact;

    private String travel;

}
