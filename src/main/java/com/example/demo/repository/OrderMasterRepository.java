package com.example.demo.repository;

import com.example.demo.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String>, JpaSpecificationExecutor<OrderMaster> {

}