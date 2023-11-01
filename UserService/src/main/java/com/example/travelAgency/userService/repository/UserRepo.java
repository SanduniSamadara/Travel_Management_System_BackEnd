package com.example.travelAgency.userService.repository;


import com.example.travelAgency.userService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User,Long> {
    User findByUsername(String username);

    boolean existsByUsername(String username);
}
