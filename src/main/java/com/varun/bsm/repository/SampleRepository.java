package com.varun.bsm.repository;

import com.varun.bsm.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository  extends JpaRepository<Sample,Integer> {
}
