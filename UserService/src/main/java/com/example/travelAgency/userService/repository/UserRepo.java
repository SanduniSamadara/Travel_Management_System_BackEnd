package com.example.travelAgency.userService.repository;


import com.example.travelAgency.userService.entity.User;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,Long> {
    User findByUserName(String userName);

    boolean existsByUserName(String userName);
}
