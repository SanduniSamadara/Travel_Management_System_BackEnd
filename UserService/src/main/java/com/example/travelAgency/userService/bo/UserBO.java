package com.example.travelAgency.userService.bo;


import com.example.travelAgency.userService.dto.ResponseDTO;
import com.example.travelAgency.userService.dto.UserDTO;

import java.io.IOException;
import java.util.List;

public interface UserBO {

    public void saveUser(UserDTO userDTO) throws IOException;

    public void updateUser(UserDTO userDTO) throws IOException;

    public UserDTO searchUser(String id);

    public void deleteUser(String id);

    public List<ResponseDTO> getAllUsers();

    boolean isExistUserByUsername(String username);

}
