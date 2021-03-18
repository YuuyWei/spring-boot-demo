package com.example.demo.repository;

import com.example.demo.entity.PhoneSpecs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PhoneSpecsRepository extends JpaRepository<PhoneSpecs, Integer>, JpaSpecificationExecutor<PhoneSpecs> {

}