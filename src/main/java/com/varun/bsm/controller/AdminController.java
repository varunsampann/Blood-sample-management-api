package com.varun.bsm.controller;

import com.varun.bsm.entity.Admin;
import com.varun.bsm.requests.AdminRequest;
import com.varun.bsm.responses.AdminResponse;
import com.varun.bsm.service.AdminService;
import com.varun.bsm.utility.ResponseStructure;
import com.varun.bsm.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final RestResponseBuilder responseBuilder;
    @PostMapping("/Admins/{userId}")
    public ResponseEntity<ResponseStructure<AdminResponse>> registerAdmin(
            @PathVariable int userId) {
        AdminResponse admin = adminService.addAdmin(userId);
        return responseBuilder.success(HttpStatus.CREATED, "Added the Admin", admin);
    }


}
