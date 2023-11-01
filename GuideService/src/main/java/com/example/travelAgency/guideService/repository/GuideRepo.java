package com.example.travelAgency.guideService.repository;

import com.example.travelAgency.guideService.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuideRepo extends MongoRepository<Guide,Long> {
    Guide findByGuideName(String name);

    boolean existsByGuideName(String name);
}
