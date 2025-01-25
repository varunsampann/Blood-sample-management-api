package com.varun.bsm.service;


import com.varun.bsm.requests.AdminRequest;
import com.varun.bsm.responses.AdminResponse;

public interface AdminService {
    AdminResponse addAdmin( int userId);
}
