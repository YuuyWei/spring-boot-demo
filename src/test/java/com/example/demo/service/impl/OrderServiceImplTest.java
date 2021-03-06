package com.example.demo.service.impl;

import com.example.demo.dto.OrderDTO;
import com.example.demo.service.OrderService;
import com.example.demo.vo.OrderDetailVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Test
    void create(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerPhone("13678787878");
        orderDTO.setBuyerAddress("广东省深圳市罗湖区科技路123号456室");
        orderDTO.setSpecsId(1);
        orderDTO.setPhoneQuantity(1);

        OrderDTO result = orderService.create(orderDTO);
        System.out.println(result);

    }

    @Test
    void findDetailOrder(){
        OrderDetailVO orderDetailVO = orderService.findOderDetailVOById("1616062080344786087");
        int id = 0;
    }

    @Test
    void pay(){
        System.out.println(orderService.pay("1616062080344786087"));
    }
}