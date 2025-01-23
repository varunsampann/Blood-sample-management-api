package com.varun.bsm.service;

import com.varun.bsm.entity.User;

public interface UserService {

    public User addUser(User user);
    public User findUserById(int userId);
    public User updateUser(User user);

//    User deleteUser(int userId);
}
