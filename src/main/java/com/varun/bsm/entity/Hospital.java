package com.varun.bsm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hospitalId;
    private String hospitalName;

    @OneToMany(mappedBy = "hospital")
    private List<Admin> admin;


//    public int getHospitalId() {
//        return hospitalId;
//    }
//
//    public void setHospitalId(int hospitalId) {
//        this.hospitalId = hospitalId;
//    }
//
//    public String getHospitalName() {
//        return hospitalName;
//    }
//
//    public void setHospitalName(String hospitalName) {
//        this.hospitalName = hospitalName;
//    }
}
