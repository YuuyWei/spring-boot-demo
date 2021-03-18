package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;

public class PhoneStockException extends RuntimeException{

    public PhoneStockException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
    }

    public PhoneStockException(String msg) {
        super(msg);
    }
}
