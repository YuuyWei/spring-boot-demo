package com.example.demo.repository;

import com.example.demo.entity.PhoneSpecs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhoneSpecsRepositoryTest {

    @Autowired
    private PhoneSpecsRepository repository;

    @Test
    void findAll(){

        List<PhoneSpecs> list = repository.findAll();

        for( PhoneSpecs phoneSpecs: list){
            System.out.println(phoneSpecs);
        }
    }
}