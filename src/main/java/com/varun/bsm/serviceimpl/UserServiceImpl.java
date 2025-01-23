package com.varun.bsm.serviceimpl;

import com.varun.bsm.entity.User;
import com.varun.bsm.exception.UserNotFoundById;
import com.varun.bsm.repository.UserRepository;
import com.varun.bsm.requests.UserRequestDto;
import com.varun.bsm.responses.UserResponseDto;
import com.varun.bsm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl  implements UserService {

//    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserResponseDto addUser(UserRequestDto userRequestDto) {
        User user = this.mapToUser(userRequestDto, new User());
        user = userRepository.save(user);

        return this.mapToResponse(user);
    }

    @Override
    public UserResponseDto findUserById(int userId) {
        Optional<User> optionals = userRepository.findById(userId);
        if(optionals.isPresent()){
            User user = optionals.get();
            return mapToResponse(user);
        }
        else{
            throw  new UserNotFoundById("user not found");
        }
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequest, int userId) {
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isEmpty()) {
            throw new UserNotFoundById("user not found by the given Id");
        }

        User user =  this.mapToUser(userRequest,optional.get());
        userRepository.save(user);

        return this.mapToResponse(user);

    }


    private  UserResponseDto mapToResponse(User user) {
        return UserResponseDto
                .builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .availableCity(user.getAvailableCity())
                .bloodGroup(user.getBloodGroup())
                .age(user.getAge())
                .gender(user.getGender())
                .lastDonateAt(user.getLastModifiedAt())
                .createdAt(user.getCreatedAt())
                .lastModifiedAt(user.getLastModifiedAt())
                .verified(user.isVerified())
                .build();
    }

    private  User mapToUser(UserRequestDto userRequest, User user) {

        user.setUserName(userRequest.getUserName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setBloodGroup(userRequest.getBloodGroup());
        user.setAge(userRequest.getAge());
        user.setGender(userRequest.getGender());
        user.setAvailableCity(userRequest.getAvailableCity());
        return user;

    }



}