package com.varun.bsm.requests;

import com.varun.bsm.enumes.BloodGroup;
import com.varun.bsm.responses.SampleResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SampleRequest {
 private BloodGroup bloodGroup;

 private int emergencyUnits;



}
