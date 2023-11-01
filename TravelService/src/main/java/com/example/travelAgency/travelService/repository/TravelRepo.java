package com.example.travelAgency.travelService.repository;

import com.example.travelAgency.travelService.entity.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepo extends JpaRepository<Travel,String> {
}
