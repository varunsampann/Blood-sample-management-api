package com.varun.bsm.controller;

import com.varun.bsm.requests.BloodbankRequest;
import com.varun.bsm.requests.SampleRequest;
import com.varun.bsm.responses.BloodBankResponse;
import com.varun.bsm.responses.SampleResponse;
import com.varun.bsm.service.BloodBankService;
import com.varun.bsm.service.SampleService;
import com.varun.bsm.utility.ResponseStructure;
import com.varun.bsm.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SampleController {

    private  final SampleService sampleService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/Samples")
    public ResponseEntity<ResponseStructure<SampleResponse>> addSample(@RequestBody SampleRequest sampleRequest){
       SampleResponse Response=sampleService.addSample(sampleRequest);
        return responseBuilder.success(HttpStatus.CREATED,"Blood Added", Response);
    }

    @GetMapping("/Samples/{sampleId}")
    public ResponseEntity<ResponseStructure<SampleResponse>> gettingSample(@PathVariable int sampleId){
        SampleResponse Response=sampleService.gettingSample(sampleId);
        return responseBuilder.success(HttpStatus.FOUND,"Blood Added", Response);
    }

    @GetMapping("/Samples")
    public ResponseEntity<ResponseStructure<List <SampleResponse>>> findAllSample(){
       List< SampleResponse> Response=sampleService.findALlSample();
        return responseBuilder.success(HttpStatus.FOUND,"Blood Added", Response);
    }





}
