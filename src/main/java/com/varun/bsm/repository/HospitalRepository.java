package com.varun.bsm.repository;

import com.varun.bsm.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital,Integer> {
}
