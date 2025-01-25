package com.varun.bsm.service;

import com.varun.bsm.requests.SampleRequest;
import com.varun.bsm.responses.SampleResponse;

import java.util.List;

public interface SampleService {
    SampleResponse addSample(SampleRequest sampleRequest);

    SampleResponse gettingSample(int sampleId);

    List<SampleResponse> findALlSample();
}
