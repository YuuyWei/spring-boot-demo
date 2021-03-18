package com.example.demo.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum {
    UNPAID(0, "未支付"),
    PAYED(1, "已支付");

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
