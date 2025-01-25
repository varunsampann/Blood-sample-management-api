package com.varun.bsm.serviceimpl;

import com.varun.bsm.entity.Admin;
import com.varun.bsm.entity.Hospital;
import com.varun.bsm.entity.User;
import com.varun.bsm.enumes.UserRole;
import com.varun.bsm.exception.HospitalNotFoundById;
import com.varun.bsm.exception.UserNotFoundById;
import com.varun.bsm.repository.AdminRepository;
import com.varun.bsm.repository.HospitalRepository;
import com.varun.bsm.repository.UserRepository;
import com.varun.bsm.requests.AdminRequest;
import com.varun.bsm.responses.AdminResponse;
import com.varun.bsm.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final HospitalRepository hospitalRepository;

    @Override
    public AdminResponse addAdmin(int userId) {


        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundById("User not found by the given Id");
        }

        User user = optionalUser.get();
//            Hospital hospital = optionalHospital.get();

        // Update the user's role to ADMIN and save
        user.setUserRole(UserRole.ADMIN);
//          User savedUser=  userRepository.save(user);

        // Create a new Admin entity
        Admin admin = new Admin();
        admin.setUser(user); // Associate the user with the admin
//            admin.setHospital(hospital); // Associate the hospital with the admin

        // Save the admin entity
        Admin savedAdmin = adminRepository.save(admin);

        // Prepare and return the response
        return AdminResponse.builder()
                .adminId(savedAdmin.getAdminId())
                .userId(user.getUserId())
//                    .hospitalId(hospital.getHospitalId())
                .user(user)
                .build();
    }


}










