package com.varun.bsm.service;

import com.varun.bsm.entity.User;
import com.varun.bsm.requests.UserRequestDto;
import com.varun.bsm.responses.UserResponseDto;

public interface UserService {

    public UserResponseDto addUser(UserRequestDto userRequestDto);
    public UserResponseDto findUserById(int userId);
    public UserResponseDto updateUser(UserRequestDto userRequestDto,int userId);

    UserResponseDto addAdminUsers(UserRequestDto userRequestDto);

    UserResponseDto promoteUser(UserRequestDto userRequestDto, int userId);

//    User deleteUser(int userId);
}
