package com.example.travelAgency.hotelService.repository;

import com.example.travelAgency.hotelService.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,String> {
}
