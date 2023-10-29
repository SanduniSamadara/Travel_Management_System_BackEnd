package com.example.travelAgency.userService.controller;


import com.example.travelAgency.userService.bo.UserBO;
import com.example.travelAgency.userService.dto.UserDTO;
import com.example.travelAgency.userService.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserBO userBO;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveUser(UserDTO userDTO) {
        userBO.saveUser(userDTO);
        return new ResponseUtil(200, "Customer Added..!", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateUser(UserDTO userDTO) {
        userBO.updateUser(userDTO);
        return new ResponseUtil(200, "Customer Updated..!", null);
    }

    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteUser(String id) {
        userBO.deleteUser(id);
        return new ResponseUtil(200,"Customer Deleted...!",null);
    }

    @GetMapping(path = "/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchUser(@PathVariable String userId){
        return new ResponseUtil(200,"Ok",userBO.searchUser(userId));
    }

    @GetMapping(produces = "application/json")
    public ResponseUtil getAllUsers() {
        return new ResponseUtil(200,"Ok",userBO.getAllUsers());

    }
}
