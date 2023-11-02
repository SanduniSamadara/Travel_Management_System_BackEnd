package com.example.travelAgency.userService.repository;


import com.example.travelAgency.userService.entity.User;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
public interface UserRepo extends MongoRepository<User,Long> {
    User findByUsername(String username);

    boolean existsByUsername(String username);
}
