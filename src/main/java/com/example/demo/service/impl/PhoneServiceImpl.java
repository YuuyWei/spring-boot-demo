package com.example.demo.service.impl;

import com.example.demo.entity.PhoneCategory;
import com.example.demo.entity.PhoneInfo;
import com.example.demo.entity.PhoneSpecs;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.PhoneStockException;
import com.example.demo.repository.PhoneCategoryRepository;
import com.example.demo.repository.PhoneInfoRepository;
import com.example.demo.repository.PhoneSpecsRepository;
import com.example.demo.service.PhoneService;
import com.example.demo.util.PhoneUtil;
import com.example.demo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneCategoryRepository phoneCategoryRepository;
    @Autowired
    private PhoneInfoRepository phoneInfoRepository;
    @Autowired
    private PhoneSpecsRepository phoneSpecsRepository;

    @Override
    public DataVO findDataVO() {
        DataVO dataVO = new DataVO();

        // PhoneCategory
        List<PhoneCategory> phoneCategories = phoneCategoryRepository.findAll();

        // stream
        List<PhoneCategoryVO> phoneCategoryVOList = phoneCategories.stream()
                .map(e -> new PhoneCategoryVO(
                        e.getCategoryName(),
                        e.getCategoryType()
                        )).collect(Collectors.toList());

        dataVO.setCategories(phoneCategoryVOList);

        // PhoneInfo
        List<PhoneInfo> phoneInfos = phoneInfoRepository.findAll();

        // stream
        List<PhoneInfoVO> phoneInfoVOList = phoneInfos.stream()
                .map(e -> new PhoneInfoVO(
                        e.getPhoneId(),
                        e.getPhoneName(),
                        e.getPhonePrice().toString(),
                        e.getPhoneDescription(),
                        e.getPhoneIcon(),
                        PhoneUtil.createTag(e.getPhoneTag())
                )).collect(Collectors.toList());

        dataVO.setPhones(phoneInfoVOList);

        return dataVO;
    }

    @Override
    public List<PhoneInfoVO> findPhoneInfoVOByCategoryType(Integer categoryType) {

        // PhoneInfo
        List<PhoneInfo> phoneInfos = phoneInfoRepository.findAllByCategoryType(categoryType);

        // stream
        List<PhoneInfoVO> phoneInfoVOList = phoneInfos.stream()
                .map(e -> new PhoneInfoVO(
                        e.getPhoneId(),
                        e.getPhoneName(),
                        e.getPhonePrice().toString(),
                        e.getPhoneDescription(),
                        e.getPhoneIcon(),
                        PhoneUtil.createTag(e.getPhoneTag())
                )).collect(Collectors.toList());

        return phoneInfoVOList;
    }

    @Override
    public SpecsPackageVO findSepecsByPhoneId(Integer phoneId) {

        // PhoneInfo
        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneId).get();

        // PhoneSpecs
        List<PhoneSpecs> phoneSpecsList = phoneSpecsRepository.findAll();

        // PhoneSpecsVO
        List<PhoneSpecsVO> phoneSpecsVOList = phoneSpecsList.stream()
                .map(e -> new PhoneSpecsVO(
                        e.getSpecsId(),
                        e.getSpecsName(),
                        e.getSpecsIcon(),
                        e.getSpecsPreview()
                )).collect(Collectors.toList());

        // PhoneSpecsCasVO
        List<PhoneSpecsCasVO> phoneSpecsCasVOList = phoneSpecsList.stream()
                .map(e -> new PhoneSpecsCasVO(
                        e.getSpecsId(),
                        e.getSpecsPrice(),
                        e.getSpecsStock()
                )).collect(Collectors.toList());

        TreeVO treeVO = new TreeVO();
        treeVO.setV(phoneSpecsVOList);
        List<TreeVO> treeVOList = new ArrayList<>();
        treeVOList.add(treeVO);

        SkuVO skuVO = new SkuVO();
        skuVO.setTree(treeVOList);
        skuVO.setList(phoneSpecsCasVOList);
        skuVO.setPhonePrice(phoneInfo.getPhonePrice().toString());
        skuVO.setPhoneStock(phoneInfo.getPhoneStock());

        Map<String, String> goods = new HashMap<>();
        goods.put("picture", phoneInfo.getPhoneIcon());

        SpecsPackageVO specsPackageVO = new SpecsPackageVO();
        specsPackageVO.setSku(skuVO);
        specsPackageVO.setGoods(goods);

        return specsPackageVO;
    }

    @Override
    public void subStock(Integer specsId, Integer quantity) {
        PhoneSpecs phoneSpecs = phoneSpecsRepository.findById(specsId).get();
        Integer phoneId = Integer.parseInt(phoneSpecs.getPhoneId());
        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneId).get();

        Integer stock = phoneSpecs.getSpecsStock();
        Integer result = stock - quantity;
        if (stock < quantity){
            throw new PhoneStockException(ResultEnum.PHONE_STOCK_ERROR);
        }
        phoneSpecs.setSpecsStock(result);
        phoneSpecsRepository.save(phoneSpecs);

        result = phoneInfo.getPhoneStock() - quantity;
        if (result < 0 ) {
            throw new PhoneStockException(ResultEnum.PHONE_STOCK_ERROR);
        }
        phoneInfo.setPhoneStock(result);
        phoneInfoRepository.save(phoneInfo);
    }
}
