package com.varun.bsm.controller;

import com.varun.bsm.entity.User;
import com.varun.bsm.requests.UserRequestDto;
import com.varun.bsm.responses.UserResponseDto;
import com.varun.bsm.service.UserService;
import com.varun.bsm.utility.ResponseStructure;
import com.varun.bsm.utility.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
//@Autowired
    private final UserService userService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/users")
    public ResponseEntity<ResponseStructure<UserResponseDto>> addUser(@RequestBody @Valid UserRequestDto userRequestDto) {
       UserResponseDto user= userService.addUser(userRequestDto);
       return responseBuilder.success(HttpStatus.CREATED, "User Created", user);

    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponseDto>> findUser(@PathVariable int userId) {
        UserResponseDto userResponseDto = userService.findUserById(userId);
        return responseBuilder.success(HttpStatus.FOUND, "User Found", userResponseDto);

    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponseDto>> updateUser(@PathVariable("userId")int userId, @RequestBody UserRequestDto userRequestDto)  {
       UserResponseDto userResponseDto = userService.updateUser(userRequestDto, userId);
        return responseBuilder.success(HttpStatus.OK, "User Updated ", userResponseDto);
    }
//    @DeleteMapping("/delete-user")
//    public ResponseEntity<ResponseStructure<User>>deleteById(@RequestParam int userId){
//            User user=userService.deleteUser(userId);
//        return responseBuilder.success(HttpStatus.FOUND, "user Deleted", user);
//    }
}