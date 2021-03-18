package com.example.demo.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SpecsPackageVO {
    Map<String, String> goods;
    private SkuVO sku;
}
