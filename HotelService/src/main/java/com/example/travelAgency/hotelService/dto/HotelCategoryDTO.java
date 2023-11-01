package com.example.travelAgency.hotelService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class HotelCategoryDTO {
    private String hotel_category_id;
    private String two_and_three_stars;
    private String three_and_four_stars;
    private String four_and_five_stars;
    private String five_stars;
}
