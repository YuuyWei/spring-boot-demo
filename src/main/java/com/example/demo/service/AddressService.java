package com.example.demo.service;

import com.example.demo.form.AddressForm;
import com.example.demo.vo.AddressVO;
import com.example.demo.vo.DataVO;
import com.example.demo.vo.PhoneInfoVO;
import com.example.demo.vo.SpecsPackageVO;

import java.util.List;

public interface AddressService {
    List<AddressVO> findAll();
    void saveOrUpdate(AddressForm addressForm);
}
