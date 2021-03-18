package com.example.demo.service;

import com.example.demo.dto.OrderDTO;
import com.example.demo.vo.OrderDetailVO;

public interface OrderService {
    OrderDTO create(OrderDTO orderDTO);
    OrderDetailVO findOderDetailVOById(String orderId);
    String pay(String orderId);
}
