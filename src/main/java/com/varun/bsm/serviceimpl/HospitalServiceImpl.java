package com.varun.bsm.serviceimpl;

import com.varun.bsm.entity.Hospital;
import com.varun.bsm.exception.HospitalNotFoundById;
import com.varun.bsm.repository.HospitalRepository;
import com.varun.bsm.requests.HospitalRequest;
import com.varun.bsm.responses.HospitalResponse;
import com.varun.bsm.service.HospitalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepository hospitalRepository;

    @Override
    public HospitalResponse registerHospital(HospitalRequest hospitalRequest) {
        Hospital hospital = this.mapToHospital(hospitalRequest,new Hospital());

         hospital= hospitalRepository.save(hospital);
         return this.mapToHospitalResponse(hospital);
    }

    @Override
    public HospitalResponse findHospitalById(int hospitalId) {
           Optional<Hospital> optional  =hospitalRepository.findById(hospitalId);
           if(optional.isPresent()){
               Hospital hospital=optional.get();
               return this.mapToHospitalResponse(hospital);
           }else{
               throw  new HospitalNotFoundById("Hospital not found");
           }

    }

    @Override
    public HospitalResponse updateHospital(int hospitalId, HospitalRequest hospitalRequest) {
       Optional<Hospital>optional= hospitalRepository.findById(hospitalId);
       if(optional.isEmpty()) {
           throw new HospitalNotFoundById("Hospital not found");
       }
       Hospital hospital =optional.get();
       hospital= this.mapToHospital(hospitalRequest,hospital);
        hospital = hospitalRepository.save(hospital);
       return this.mapToHospitalResponse(hospital);
    }


    private HospitalResponse mapToHospitalResponse(Hospital hospital) {
        return HospitalResponse
                .builder()
                .hospitalId(hospital.getHospitalId())
                .hospitalName(hospital.getHospitalName())
                .build();
    }

    private Hospital mapToHospital(HospitalRequest hospitalRequest, Hospital hospital) {
       hospital.setHospitalName(hospitalRequest.getHospitalName());
        return hospital;
    }
}
