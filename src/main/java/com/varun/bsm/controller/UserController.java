package com.varun.bsm.controller;

import com.varun.bsm.entity.User;
import com.varun.bsm.service.UserService;
import com.varun.bsm.utility.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<User>>addUser(@RequestBody User user) {
        user = userService.addUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ResponseStructure.create(HttpStatus.CREATED.value(), "User Created", user));

    }
    @GetMapping("/find-user-by-id")
    public ResponseEntity<ResponseStructure<User>>findUser(@RequestParam int userId) {
      User user = userService.findUserById(userId);
      return ResponseEntity
              .status(HttpStatus.FOUND)
              .body(ResponseStructure.create(HttpStatus.FOUND.value(), "User Founded", user));

    }
    @PutMapping("/update-user")
    public ResponseEntity<ResponseStructure<User>>updateUser(@RequestBody User user) {
        user = userService.updateUser(user);
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(ResponseStructure.create(HttpStatus.FOUND.value(), "User Founded", user));
    }
}
