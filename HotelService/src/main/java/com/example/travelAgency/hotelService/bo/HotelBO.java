package com.example.travelAgency.hotelService.bo;

import com.example.travelAgency.hotelService.dto.HotelDTO;

import java.util.List;

public interface HotelBO {
    public void saveHotel(HotelDTO hotelDTO);

    public void updateHotel(HotelDTO hotelDTO);

    public HotelDTO searchHotel(String id);

    public void deleteHotel(String id);

    public List<HotelDTO> getAllHotels();
}
