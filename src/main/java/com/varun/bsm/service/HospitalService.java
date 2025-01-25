package com.varun.bsm.service;

import com.varun.bsm.requests.HospitalRequest;
import com.varun.bsm.responses.HospitalResponse;

public interface HospitalService {
    HospitalResponse registerHospital(HospitalRequest hospitalRequest);

    HospitalResponse findHospitalById(int hospitalId);

    HospitalResponse updateHospital(int hospitalId, HospitalRequest hospitalRequest);

//    HospitalResponse addAdminHospital(HospitalRequest hospitalRequest, int userId);
}
