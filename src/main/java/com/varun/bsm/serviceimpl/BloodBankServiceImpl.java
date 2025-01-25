package com.varun.bsm.serviceimpl;

import com.varun.bsm.entity.BloodBank;
import com.varun.bsm.exception.BloodBankNotFoundById;
import com.varun.bsm.repository.BloodBankRepository;
import com.varun.bsm.requests.BloodbankRequest;
import com.varun.bsm.responses.BloodBankResponse;
import com.varun.bsm.service.BloodBankService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BloodBankServiceImpl implements BloodBankService {

    private BloodBankRepository bloodBankRepository;

    @Override
    public BloodBankResponse addBlood(BloodbankRequest bloodbankRequest) {
        BloodBank bloodBank = mapToBank(bloodbankRequest, new BloodBank());

        bloodBank = bloodBankRepository.save(bloodBank);
        return mapToBloodResponse(bloodBank);
    }

    @Override
    public BloodBankResponse findBloodBankById(int bankId) {
        Optional<BloodBank> optional = bloodBankRepository.findById(bankId);
        if (optional.isPresent()) {
            BloodBank bloodBank = optional.get();
            return mapToBloodResponse(bloodBank);
        } else {
            throw new BloodBankNotFoundById("BloodBank Not Found");
        }

    }

    @Override
    public BloodBankResponse updateBank(int bankId, BloodbankRequest bloodbankRequest) {
        Optional<BloodBank> optional = bloodBankRepository.findById(bankId);
        if (optional.isEmpty()) {
            throw new BloodBankNotFoundById("Not Found the Bloodbank");
        }
        BloodBank bloodBank = mapToBank(bloodbankRequest, optional.get());
        bloodBank = bloodBankRepository.save(bloodBank);
        return mapToBloodResponse(bloodBank);
    }

    @Override
    public List<BloodBankResponse> AllBloodBanks() {
        List<BloodBank> bloodBanks = bloodBankRepository.findAll();
        if (bloodBanks.isEmpty()) {
            throw new BloodBankNotFoundById(" is Empty ");
        }
        List<BloodBankResponse> responses = new ArrayList<>();
        for (BloodBank bloodBank : bloodBanks) {
            BloodBankResponse response = mapToBloodResponse(bloodBank);
            responses.add(response);
        }
        return responses;
    }

    private BloodBankResponse mapToBloodResponse(BloodBank bloodBank) {
        return BloodBankResponse
                .builder()
                .bankId(bloodBank.getBankId())
                .bankName(bloodBank.getBankName())
                .emergencyUnitCount(bloodBank.getEmergencyUnitCount())
                .build();
    }

    private BloodBank mapToBank(BloodbankRequest bloodbankRequest, BloodBank bloodBank) {
        bloodBank.setBankName(bloodbankRequest.getBankName());
        bloodBank.setEmergencyUnitCount(bloodbankRequest.getEmergencyUnitCount());
        return bloodBank;
    }
}
