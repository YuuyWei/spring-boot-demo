package com.example.demo.repository;

import com.example.demo.entity.BuyerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BuyerAddressRepository extends JpaRepository<BuyerAddress, Integer>, JpaSpecificationExecutor<BuyerAddress> {

}