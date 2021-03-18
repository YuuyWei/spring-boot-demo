package com.example.demo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SkuVO {
    private List<TreeVO> tree;
    private List<PhoneSpecsCasVO> list;
    @JsonProperty("price")
    private String phonePrice;
    @JsonProperty("stock_num")
    private Integer phoneStock;
    private boolean none_sku = false;
    private boolean hide_stock = false;
}
