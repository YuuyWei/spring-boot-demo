package com.example.demo.controller;

import com.example.demo.dto.OrderDTO;
import com.example.demo.exception.PhoneStockException;
import com.example.demo.form.OrderForm;
import com.example.demo.repository.OrderMasterRepository;
import com.example.demo.service.OrderService;
import com.example.demo.service.PhoneService;
import com.example.demo.util.ResultVOUtil;
import com.example.demo.vo.OrderDetailVO;
import com.example.demo.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderHandler {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@RequestBody OrderForm orderForm, BindingResult bindingResult){

        System.out.println(orderForm);
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数错误, orderForm = {}", orderForm);
            throw new PhoneStockException(bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerPhone(orderForm.getTel());
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setPhoneQuantity(orderForm.getQuantity());
        orderDTO.setSpecsId(orderForm.getSpecsId());

        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> data = new HashMap<>();
        data.put("orderId", result.getOrderId());

        return ResultVOUtil.success(data);
    }

    @GetMapping("/detail/{orderId}")
    public ResultVO<OrderDetailVO> detail(@PathVariable("orderId") String orderId) {

        OrderDetailVO orderDetailVO = orderService.findOderDetailVOById(orderId);

        return ResultVOUtil.success(orderDetailVO);
    }

    @PutMapping("/pay/{orderId}")
    public ResultVO<Map<String, String>> pay(@PathVariable("orderId") String orderId){

        String result = orderService.pay(orderId);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result);

        return ResultVOUtil.success(map);
    }

}
