package com.example.demo.service;

import com.example.demo.form.AddressForm;
import com.example.demo.vo.AddressVO;

import java.util.List;

public interface AddressService {
    List<AddressVO> findAll();
    void saveOrUpdate(AddressForm addressForm);
}
