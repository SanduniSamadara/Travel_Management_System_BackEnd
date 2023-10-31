package com.example.travelAgency.hotelService.dto;

import com.example.travelAgency.hotelService.entity.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HotelDTO {
    private String hotelId;
    private String name;
    private boolean isPetAllowed;
    private String location;
    private double hotelFee;
    private String email;
    private String remarks;
    private Contact contact;

}
