package com.example.demo.controller;

import com.example.demo.entity.PhoneInfo;
import com.example.demo.service.PhoneService;
import com.example.demo.util.ResultVOUtil;
import com.example.demo.vo.DataVO;
import com.example.demo.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phone")
public class PhoneHandler {

    @Autowired
    private PhoneService phoneService;

    @GetMapping("/index")
    public ResultVO<DataVO> index(){
        return ResultVOUtil.success(phoneService.findDataVO());
    }

    @GetMapping("/findByCategoryType/{categoryType}")
    public ResultVO<PhoneInfo> findByCategoryType(@PathVariable("categoryType") Integer categoryType){
        return ResultVOUtil.success(phoneService.findPhoneInfoVOByCategoryType(categoryType));
    }

    @GetMapping("/findSpecsByPhoneId/{phoneId}")
    public ResultVO<PhoneInfo> findById(@PathVariable("phoneId") Integer phoneId){
        return ResultVOUtil.success(phoneService.findSepecsByPhoneId(phoneId));
    }
}
