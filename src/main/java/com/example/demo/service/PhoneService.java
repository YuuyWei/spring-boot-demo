package com.example.demo.service;

import com.example.demo.vo.DataVO;
import com.example.demo.vo.PhoneInfoVO;
import com.example.demo.vo.SpecsPackageVO;

import java.util.List;

public interface PhoneService {
    DataVO findDataVO();
    List<PhoneInfoVO> findPhoneInfoVOByCategoryType(Integer categoryType);
    SpecsPackageVO findSepecsByPhoneId(Integer phoneId);
    void subStock(Integer specsId, Integer quantity);
}
