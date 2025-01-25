package com.varun.bsm.entity;

import com.varun.bsm.enumes.BloodGroup;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int sampleId;
    private BloodGroup bloodGroup;
    private int quantity;
    private  boolean availability;
    private  int emergencyUnit;
    private  int availableUnits;


}
