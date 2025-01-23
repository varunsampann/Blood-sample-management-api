package com.varun.bsm.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BloodBankResponse {

    private int bankId;
    private String bankName;
    private int emergencyUnitCount;
}
