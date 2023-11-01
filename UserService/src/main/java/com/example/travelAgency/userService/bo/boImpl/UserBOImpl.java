package com.example.travelAgency.userService.bo.boImpl;

import com.example.travelAgency.userService.bo.UserBO;
import com.example.travelAgency.userService.bo.exception.AlreadyExistException;
import com.example.travelAgency.userService.bo.exception.NotFoundException;
import com.example.travelAgency.userService.dto.ResponseDTO;
import com.example.travelAgency.userService.dto.UserDTO;
import com.example.travelAgency.userService.entity.User;
import com.example.travelAgency.userService.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@Transactional
public class UserBOImpl implements UserBO {

    private final ModelMapper mapper;
    private final UserRepo repository;

    @Autowired
    public UserBOImpl(ModelMapper mapper, UserRepo repository) {
        this.mapper = mapper;
        this.repository = repository;
    }


    @Override
    public void saveUser(UserDTO user) throws IOException {
        User userEntity = mapper.map(user, User.class);
        if (repository.findByUsername(user.getUserName()) != null) {
            throw new AlreadyExistException("Username already exists. Username is " + user.getUserName());
        } else {

            String imgBase64 = Base64.getEncoder().encodeToString(user.getUser_nic_image_front_view().getBytes());
            userEntity.setUser_nic_image_front_view(imgBase64);
            String encode = Base64.getEncoder().encodeToString(user.getUser_nic_image_rare_view().getBytes());
            userEntity.setUser_nic_image_rare_view(encode);

            repository.save(userEntity);
        }
    }

    @Override
    public void updateUser(UserDTO user) throws IOException {
        User userEntity = mapper.map(user, User.class);
        if (repository.findByUsername(user.getUserName()) == null) {
            throw new NotFoundException("Username not found. Username is " + user.getUserName());
        } else {
            String imgBase64 = Base64.getEncoder().encodeToString(user.getUser_nic_image_front_view().getBytes());
            userEntity.setUser_nic_image_front_view(imgBase64);
            String encode = Base64.getEncoder().encodeToString(user.getUser_nic_image_rare_view().getBytes());
            userEntity.setUser_nic_image_rare_view(encode);

            repository.save(userEntity);

        }
    }

    @Override
    public UserDTO searchUser(String id) {
        return null;
    }

  /*  @Override
    public UserDTO searchUser(String id) {
       *//* if (userRepo.existsById(id)) {
            User user = userRepo.findById(id).get();
            return conversion.getUserDTO(user);
        }
        return null;*//*
       *//* User byUsername = repository.findByUsername(use);
        if ( byUsername== null) {
            throw new NotFoundException("Username not found. Username is " + userName);
        } else {
            repository.findByUsername(byUsername);
        }*//*
    }
 */

    @Override
    public void deleteUser(String userName) {
        User byUsername = repository.findByUsername(userName);
        if ( byUsername== null) {
            throw new NotFoundException("Username not found. Username is " + userName);
        } else {
            repository.delete(byUsername);
        }
    }

    @Override
    public List<ResponseDTO> getAllUsers() {
        return mapper.map(repository.findAll(), new TypeToken<List<ResponseDTO>>() {
        }.getType());    }

    @Override
    public boolean isExistUserByUsername(String username) {
        return repository.existsByUsername(username);
    }
}
