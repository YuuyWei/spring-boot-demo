package com.example.demo.repository;

import com.example.demo.entity.OrderMaster;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    void findAll() {

        List<OrderMaster> list = orderMasterRepository.findAll();
        for (OrderMaster orderMaster: list) {
            System.out.println(orderMaster);
        }
    }
}