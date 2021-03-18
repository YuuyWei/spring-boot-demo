package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

//areaCode: "440303",
//id: 21,
//name: "张三",
//tel: "13678787878",
//address: "广东省深圳市罗湖区科技路123号456室"
@AllArgsConstructor
@Data
public class AddressVO {
    private String areaCode;
    private Integer id;
    private String name;
    private String tel;
    private String address;
}
