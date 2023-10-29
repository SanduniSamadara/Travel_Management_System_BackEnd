package com.example.travelAgency.guideService.repository;

import com.example.travelAgency.guideService.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepo extends JpaRepository<Guide,String> {
}
