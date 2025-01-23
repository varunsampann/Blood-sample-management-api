package com.varun.bsm.repository;

import com.varun.bsm.entity.BloodBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodBankRepository  extends JpaRepository<BloodBank,Integer> {
}
