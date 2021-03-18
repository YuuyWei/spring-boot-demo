package com.example.demo.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AddressForm {

    private Integer id;
    @NotEmpty(message = "姓名不能为空")
    private String name;
    @NotEmpty(message = "电话不能为空")
    private String tel;
    @NotEmpty(message = "省份不能为空")
    private String province;
    @NotEmpty(message = "城市不能为空")
    private String city;
    @NotEmpty(message = "社区不能为空")
    private String county;
    @NotEmpty(message = "地区代码不能为空")
    private String areaCode;
    @NotEmpty(message = "详细地址不能为空")
    private String addressDetail;
}
