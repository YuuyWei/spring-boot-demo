package com.example.demo.service.impl;

import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.OrderMaster;
import com.example.demo.entity.PhoneInfo;
import com.example.demo.entity.PhoneSpecs;
import com.example.demo.enums.PayStatusEnum;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.PhoneStockException;
import com.example.demo.repository.OrderMasterRepository;
import com.example.demo.repository.PhoneInfoRepository;
import com.example.demo.repository.PhoneSpecsRepository;
import com.example.demo.service.OrderService;
import com.example.demo.service.PhoneService;
import com.example.demo.util.KeyUtil;
import com.example.demo.vo.OrderDetailVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private PhoneSpecsRepository phoneSpecsRepository;

    @Autowired
    private PhoneInfoRepository phoneInfoRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private PhoneService phoneService;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);

        PhoneSpecs phoneSpecs = phoneSpecsRepository.findById(orderDTO.getSpecsId()).get();
        if (phoneSpecs == null) {
            log.error("【创建订单】规格不存在, phoneSpecs = {}", phoneSpecs);
            throw new PhoneStockException(ResultEnum.ORDER_NOT_EXIST);
        }
        BeanUtils.copyProperties(phoneSpecs, orderMaster);

        PhoneInfo phoneInfo = phoneInfoRepository.findById(Integer.parseInt(phoneSpecs.getPhoneId())).get();
        if (phoneInfo == null) {
            log.error("【创建订单】手机不存在, phoneInfo = {}", phoneInfo);
            throw new PhoneStockException(ResultEnum.PHONE_NOT_EXIST);
        }
        BeanUtils.copyProperties(phoneInfo, orderMaster);

        // Total amount
        BigDecimal orderAmount = new BigDecimal(0);
        orderAmount = phoneSpecs.getSpecsPrice().divide(new BigDecimal(100))
                .multiply(new BigDecimal(orderDTO.getPhoneQuantity()))
                .add(orderAmount)
                .add(new BigDecimal(10));

        orderMaster.setOrderAmount(orderAmount);

        // OrderId
        orderMaster.setOrderId(KeyUtil.createUniqueKey());
        orderDTO.setOrderId(orderMaster.getOrderId());

        // PayStatus
        orderMaster.setPayStatus(PayStatusEnum.UNPAID.getCode());

        orderMasterRepository.save(orderMaster);

        phoneService.subStock(orderDTO.getSpecsId(), orderDTO.getPhoneQuantity());

        return orderDTO;
    }

    @Override
    public OrderDetailVO findOderDetailVOById(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();
        if (orderMaster == null) {
            log.error("【查询订单】订单不存在, orderMaster = {}", orderMaster);
            throw new PhoneStockException(ResultEnum.PHONE_NOT_EXIST);
        }

        OrderDetailVO orderDetailVO = new OrderDetailVO();

        BeanUtils.copyProperties(orderMaster, orderDetailVO);
        orderDetailVO.setSpecsPrice(orderMaster.getSpecsPrice().divide(new BigDecimal(100)).toString());

        return orderDetailVO;
    }

    @Override
    public String pay(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();
        if (orderMaster == null) {
            log.error("【查询订单】订单不存在, orderMaster = {}", orderMaster);
            throw new PhoneStockException(ResultEnum.PHONE_NOT_EXIST);
        }

        if (orderMaster.getPayStatus().equals(PayStatusEnum.UNPAID.getCode())){
            orderMaster.setPayStatus(PayStatusEnum.PAYED.getCode());
        } else {
            log.error("【支付订单】订单已支付, orderMaster = {}", orderMaster);
            throw new PhoneStockException(ResultEnum.ORDER_GET_PAYED);
        }
        orderMaster.setPayStatus(PayStatusEnum.PAYED.getCode());

        orderMasterRepository.save(orderMaster);

        return orderId;
    }
}
