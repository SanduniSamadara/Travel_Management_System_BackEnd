package com.example.travelAgency.userService.util;


import com.example.travelAgency.userService.dto.UserDTO;
import com.example.travelAgency.userService.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConversion {
    private final ModelMapper modelMapper;

    public EntityDTOConversion(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public User getUserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public UserDTO getUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}