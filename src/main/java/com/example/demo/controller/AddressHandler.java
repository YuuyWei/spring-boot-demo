package com.example.demo.controller;

import com.example.demo.form.AddressForm;
import com.example.demo.repository.BuyerAddressRepository;
import com.example.demo.service.AddressService;
import com.example.demo.util.ResultVOUtil;
import com.example.demo.vo.AddressVO;
import com.example.demo.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressHandler {

    @Autowired
    private AddressService addressService;

    @GetMapping("/list")
    public ResultVO<AddressVO> list(){
        return ResultVOUtil.success(addressService.findAll());
    }

    @PostMapping("/create")
    public ResultVO createAddress(@RequestBody AddressForm addressForm) {
        addressService.saveOrUpdate(addressForm);

        return ResultVOUtil.success(null);
    }

    @PutMapping("/update")
    public ResultVO updateAddress(@RequestBody AddressForm addressForm){

        addressService.saveOrUpdate(addressForm);

        return ResultVOUtil.success(null);
    }


}
