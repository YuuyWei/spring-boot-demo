package com.example.demo.service.impl;

import com.example.demo.service.PhoneService;
import com.example.demo.vo.DataVO;
import com.example.demo.vo.PhoneInfoVO;
import com.example.demo.vo.SpecsPackageVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PhoneServiceImplTest {

    @Autowired
    private PhoneService phoneService;

    @Test
    void findDataVO(){
        DataVO dataVO = phoneService.findDataVO();
        int id = 0;
    }

    @Test
    void findPhoneInfoVOByCategoryType(){
        List<PhoneInfoVO> list = phoneService.findPhoneInfoVOByCategoryType(1);
        int id = 0;
    }

    @Test
    void findSepecsByPhoneId(){
        SpecsPackageVO specsPackageVO = phoneService.findSepecsByPhoneId(1);
        int id = 0;
    }

    @Test
    void subStock(){
        phoneService.subStock(2, 1);
    }
}