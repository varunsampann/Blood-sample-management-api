package com.varun.bsm.serviceimpl;

import com.varun.bsm.entity.Sample;
import com.varun.bsm.exception.SampleNotFoundById;
import com.varun.bsm.repository.SampleRepository;
import com.varun.bsm.requests.SampleRequest;
import com.varun.bsm.responses.BloodBankResponse;
import com.varun.bsm.responses.SampleResponse;
import com.varun.bsm.service.SampleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SampleServiceImpl implements SampleService {

    private  final SampleRepository sampleRepository;
    @Override
    public SampleResponse addSample(SampleRequest sampleRequest) {
        Sample sample =mapToSample(sampleRequest, new Sample());
       sample= sampleRepository.save(sample);
            return mapToSampleResponse(sample);
    }

    @Override
    public SampleResponse gettingSample(int sampleId) {
            Optional<Sample> optional = sampleRepository.findById(sampleId);
            if(optional.isEmpty()){
                throw  new SampleNotFoundById("sample not found");
            }

            Sample sample =optional.get();

            return mapToSampleResponse(sample);
    }

    @Override
    public List<SampleResponse> findALlSample() {
      List<Sample> sampleList = sampleRepository.findAll();
      if(sampleList.isEmpty()){
          throw new SampleNotFoundById("Sample List is empty");
      }
      List<SampleResponse> responses = new ArrayList<>();
      for(Sample samples: sampleList){
          SampleResponse response = this.mapToSampleResponse(samples);
          responses.add(response);
      }
      return responses;

    }

    private SampleResponse mapToSampleResponse(Sample sample) {
        return SampleResponse.builder()
                .sampleId(sample.getSampleId())
                .bloodGroup(sample.getBloodGroup())
                .quantity(sample.getQuantity())
                .availability(sample.isAvailability())
                .emegencyUnits(sample.getAvailableUnits())
                .availableUnits(sample.getAvailableUnits())
                .build();
    }

    private Sample mapToSample(SampleRequest sampleRequest, Sample sample) {
            sample.setBloodGroup(sampleRequest.getBloodGroup());
            sample.setEmergencyUnit(sampleRequest.getEmergencyUnits());
       return  sample;
    }
}