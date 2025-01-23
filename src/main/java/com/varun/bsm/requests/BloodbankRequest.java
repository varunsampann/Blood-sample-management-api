package com.varun.bsm.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BloodbankRequest {

    @NotNull(message = "Bloodbank cannot be null.")
    @NotBlank(message = "BloodBank cannot be blank.")
    private String bankName;

        private int emergencyUnitCount;
}
