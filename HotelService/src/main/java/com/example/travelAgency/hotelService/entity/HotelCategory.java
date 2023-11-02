package com.example.travelAgency.hotelService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HotelCategory implements Super{
    @Id
    @ManyToOne(optional = false)
    private HotelCategory Hotel_category_id;
    private String two_and_three_stars;
    private String three_and_four_stars;
    private String four_and_five_stars;
    private String five_stars;
}
