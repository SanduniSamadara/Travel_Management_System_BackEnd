package com.example.travelAgency.userService.controller;


import com.example.travelAgency.userService.bo.UserBO;
import com.example.travelAgency.userService.dto.ResponseDTO;
import com.example.travelAgency.userService.dto.UserDTO;
import com.example.travelAgency.userService.util.ResponseUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {

    private final UserBO userBO;

    @Autowired
    public UserController(UserBO userBO) {
        this.userBO = userBO;
    }


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseUtil<UserDTO> saveUser(@ModelAttribute @Valid UserDTO user) throws IOException {
        userBO.saveUser(user);
        return new ResponseUtil<UserDTO>(201, "Saved", null);
    }


    @PutMapping
    public ResponseUtil<UserDTO> updateUser(@ModelAttribute @Valid UserDTO user) throws IOException {
        userBO.updateUser(user);
        return new ResponseUtil<UserDTO>(200, "Updated", null);
    }

    @DeleteMapping(path = "/{username}")
    public ResponseUtil<UserDTO> deleteUser(@PathVariable("username") String username) throws IOException {
        userBO.deleteUser(username);
        return new ResponseUtil<UserDTO>(200, "Deleted", null);
    }

    @GetMapping
    public ResponseUtil<List<ResponseDTO>> getAllUsers(){
        return new ResponseUtil<>(200,"Ok",userBO.getAllUsers());
    }

    @GetMapping(path = "/username")
    public boolean isExistUserByUsername(@RequestParam("username") String username){
        return userBO.isExistUserByUsername(username);
    }
}
