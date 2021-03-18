package com.example.demo.service.impl;

import com.example.demo.entity.BuyerAddress;
import com.example.demo.form.AddressForm;
import com.example.demo.repository.BuyerAddressRepository;
import com.example.demo.service.AddressService;
import com.example.demo.vo.AddressVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private BuyerAddressRepository buyerAddressRepository;

    @Override
    public List<AddressVO> findAll() {
        return buyerAddressRepository.findAll().stream()
                .map(e -> new AddressVO(
                        e.getAreaCode(),
                        e.getAddressId(),
                        e.getBuyerName(),
                        e.getBuyerPhone(),
                        e.getBuyerAddress()
                )).collect(Collectors.toList());
    }

    @Override
    public void saveOrUpdate(AddressForm addressForm) {
        BuyerAddress buyerAddress;
        if (addressForm.getId() == null) {
            buyerAddress = new BuyerAddress();
            Date now = new Date();
            buyerAddress.setCreateTime(now);
            buyerAddress.setUpdateTime(now);
        } else {
            buyerAddress = buyerAddressRepository.findById(addressForm.getId()).get();
            buyerAddress.setUpdateTime(new Date());
        }
        buyerAddress.setBuyerName(addressForm.getName());
        buyerAddress.setBuyerPhone(addressForm.getTel());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(addressForm.getProvince())
                .append(addressForm.getCity())
                .append(addressForm.getCounty())
                .append(addressForm.getAddressDetail());
        buyerAddress.setBuyerAddress(stringBuffer.toString());
        buyerAddress.setAreaCode(addressForm.getAreaCode());

        buyerAddressRepository.save(buyerAddress);
    }
}
