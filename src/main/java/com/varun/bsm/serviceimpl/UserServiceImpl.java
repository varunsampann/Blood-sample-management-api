package com.varun.bsm.serviceimpl;

import com.varun.bsm.entity.User;
import com.varun.bsm.exception.UserNotFoundById;
import com.varun.bsm.repository.UserRepository;
import com.varun.bsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
      return userRepository.save(user);
    }

    @Override
    public User findUserById(int userId) {
        Optional<User> optionals = userRepository.findById(userId);
        if(optionals.isPresent()){
            return optionals.get();
        }
        else{
            throw  new UserNotFoundById("user not found by the given Id");
        }
    }

    @Override
    public User updateUser(User user) {
        Optional<User> optionals = userRepository.findById(user.getUserId());
        if (optionals.isPresent()) {
            User exUser = optionals.get();
            exUser.setUserName(user.getUserName());
            exUser.setEmail(user.getEmail());
            exUser.setPassword(user.getPassword());
            exUser.setPhoneNumber(user.getPhoneNumber());
            exUser.setBloodGroup(user.getBloodGroup());
            exUser.setLastDonateAt(user.getLastDonateAt());
            exUser.setAge(user.getAge());
            exUser.setGender(user.getGender());
            exUser.setAvailableCity(user.getAvailableCity());
            exUser.setVerified(user.isVerified());
            return userRepository.save(exUser);
        } else {
            throw new UserNotFoundById("user not found by the given Id");
        }
    }
}
