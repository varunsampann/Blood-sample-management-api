package com.varun.bsm.responses;

import com.varun.bsm.enumes.BloodGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SampleResponse {

    private int sampleId;
    private BloodGroup bloodGroup;
    private  int quantity;
    private boolean availability;
    private int emegencyUnits;
    private int availableUnits;

}
