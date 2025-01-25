package com.varun.bsm.service;

import com.varun.bsm.requests.BloodbankRequest;
import com.varun.bsm.requests.SampleRequest;
import com.varun.bsm.responses.BloodBankResponse;
import com.varun.bsm.responses.SampleResponse;

import java.util.List;

public interface BloodBankService {
    public BloodBankResponse addBlood(BloodbankRequest bloodbankRequest);

    BloodBankResponse findBloodBankById(int bankId);

    BloodBankResponse updateBank(int bankId, BloodbankRequest bloodbankRequest);

   List<BloodBankResponse> AllBloodBanks();


}
