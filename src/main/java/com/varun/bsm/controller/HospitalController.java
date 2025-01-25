package com.varun.bsm.controller;

import com.varun.bsm.entity.Hospital;
import com.varun.bsm.requests.HospitalRequest;
import com.varun.bsm.responses.HospitalResponse;
import com.varun.bsm.service.HospitalService;
import com.varun.bsm.utility.ResponseStructure;
import com.varun.bsm.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class HospitalController {

    private HospitalService hospitalService;
    private RestResponseBuilder responseBuilder;

    @PostMapping("/Hospital")
    public ResponseEntity<ResponseStructure<HospitalResponse>> registerHospital(@RequestBody HospitalRequest hospitalRequest){
       HospitalResponse  hospital =hospitalService.registerHospital(hospitalRequest);
       return responseBuilder.success(HttpStatus.CREATED,"Hospital registered",hospital);
    }

    @GetMapping("/Hospitals/{hospitalId}")
    public ResponseEntity<ResponseStructure<HospitalResponse>> findHospitalById(@PathVariable int hospitalId){
        HospitalResponse hospital =hospitalService.findHospitalById(hospitalId);
        return responseBuilder.success(HttpStatus.FOUND,"Hospital Found",hospital);
    }

    @PutMapping("/Hospitals/{hospitalId}")
    public ResponseEntity<ResponseStructure<HospitalResponse>> updateHospital(@PathVariable("hospitalId")int hospitalId, @RequestBody HospitalRequest hospitalRequest){
        HospitalResponse hospital=hospitalService.updateHospital(hospitalId,hospitalRequest);
        return responseBuilder.success(HttpStatus.OK,"Hospital updated",hospital);
    }

//    @PostMapping("/hospitals-admin/{userId}")
//    public ResponseEntity<ResponseStructure<HospitalResponse>> addAdminHospital(@RequestBody HospitalRequest hospitalRequest, @PathVariable int userId){
//        HospitalResponse hospital=hospitalService.addAdminHospital(hospitalRequest, userId);
//        return responseBuilder.success(HttpStatus.OK,"Hospital updated",hospital);
//    }
}
