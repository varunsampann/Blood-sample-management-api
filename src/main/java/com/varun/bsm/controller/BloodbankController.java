package com.varun.bsm.controller;

import com.varun.bsm.requests.BloodbankRequest;
import com.varun.bsm.responses.BloodBankResponse;
import com.varun.bsm.service.BloodBankService;
import com.varun.bsm.utility.ResponseStructure;
import com.varun.bsm.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
public class BloodbankController {

    private final BloodBankService bloodBankService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/BloodBank")
    public ResponseEntity<ResponseStructure<BloodBankResponse>> addBlood(@RequestBody BloodbankRequest bloodbankRequest){
        BloodBankResponse bloodBankResponse=bloodBankService.addBlood(bloodbankRequest);
        return responseBuilder.success(HttpStatus.CREATED,"Blood Added", bloodBankResponse);
    }
    @GetMapping("/BloodBanks/{bankId}")
    public  ResponseEntity<ResponseStructure<BloodBankResponse>> findBloodbankById(@PathVariable int bankId){
         BloodBankResponse bloodBankResponse=bloodBankService.findBloodBankById(bankId);
         return responseBuilder.success(HttpStatus.FOUND,"BloodBank founded",bloodBankResponse);
    }
    @PutMapping("/BloodBanks/{bankId}")
    public ResponseEntity<ResponseStructure<BloodBankResponse>>UpdateBloodBank(@PathVariable int bankId,@RequestBody BloodbankRequest bloodbankRequest){
       BloodBankResponse bloodBankResponse= bloodBankService.updateBank(bankId,bloodbankRequest);
        return responseBuilder.success(HttpStatus.FOUND,"BloodBank Updated",bloodBankResponse);
    }
    @GetMapping("BloodBanks")
    public ResponseEntity<ResponseStructure<List<BloodBankResponse>>> getAllBloodBanks() {
        // Fetch all blood banks from the service
        List<BloodBankResponse> bloodBankResponses = bloodBankService.AllBloodBanks();

        // Build and return the response
        return responseBuilder.success(HttpStatus.FOUND, "Blood Banks Retrieved Successfully", bloodBankResponses);
    }


}
