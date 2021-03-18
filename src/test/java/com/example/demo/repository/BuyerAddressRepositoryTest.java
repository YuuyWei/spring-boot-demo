package com.example.demo.repository;

import com.example.demo.entity.BuyerAddress;
import com.example.demo.entity.PhoneInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BuyerAddressRepositoryTest {

    @Autowired
    private BuyerAddressRepository repository;

    @Test
    void findAll() {
        List<BuyerAddress> list = repository.findAll();

        for (BuyerAddress buyerAddress: list) {
            System.out.println(buyerAddress);
        }
    }

}