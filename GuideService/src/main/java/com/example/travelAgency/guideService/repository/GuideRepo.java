package com.example.travelAgency.guideService.repository;

import com.example.travelAgency.guideService.entity.Guide;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
public interface GuideRepo extends MongoRepository<Guide,Long> {
    Guide findByGuideName(String name);

    boolean existsByGuideName(String name);
}
