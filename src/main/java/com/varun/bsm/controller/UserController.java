package com.varun.bsm.controller;

import com.varun.bsm.entity.User;
import com.varun.bsm.service.UserService;
import com.varun.bsm.utility.ResponseStructure;
import com.varun.bsm.utility.RestResponseBuilder;
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
    public ResponseEntity<ResponseStructure<User>> addUser(@RequestBody User user) {
        user = userService.addUser(user);
       return responseBuilder.success(HttpStatus.CREATED, "User Created", user);


    }

    @GetMapping("/users")
    public ResponseEntity<ResponseStructure<User>> findUser(@RequestParam int userId) {
        User user = userService.findUserById(userId);
        return responseBuilder.success(HttpStatus.FOUND, "User Found", user);

    }

    @PutMapping("/users")
    public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user) {
        user = userService.updateUser(user);
        return responseBuilder.success(HttpStatus.FOUND, "User Found", user);
    }
//    @DeleteMapping("/delete-user")
//    public ResponseEntity<ResponseStructure<User>>deleteById(@RequestParam int userId){
//            User user=userService.deleteUser(userId);
//        return responseBuilder.success(HttpStatus.FOUND, "user Deleted", user);
//    }
}