package com.varun.bsm.requests;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class HospitalRequest {
    @NotNull(message = "HospitalName cannot be null.")
    @NotBlank(message = "HospitalName cannot be blank.")
    private String hospitalName;
}
