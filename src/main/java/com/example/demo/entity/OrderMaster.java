package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表
 */
@Data
@Entity
@Table(name = "order_master")
public class OrderMaster implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "order_id", nullable = false)
    private String orderId;

    /**
     * 买家名字
     */
    @Column(name = "buyer_name", nullable = false)
    private String buyerName;

    /**
     * 买家电话
     */
    @Column(name = "buyer_phone", nullable = false)
    private String buyerPhone;

    /**
     * 买家地址
     */
    @Column(name = "buyer_address", nullable = false)
    private String buyerAddress;

    /**
     * 商品编号
     */
    @Column(name = "phone_id")
    private Integer phoneId;

    /**
     * 商品名称
     */
    @Column(name = "phone_name")
    private String phoneName;

    /**
     * 商品数量
     */
    @Column(name = "phone_quantity")
    private Integer phoneQuantity;

    /**
     * 商品小图
     */
    @Column(name = "phone_icon")
    private String phoneIcon;

    /**
     * 规格编号
     */
    @Column(name = "specs_id")
    private Integer specsId;

    /**
     * 规格名称
     */
    @Column(name = "specs_name")
    private String specsName;

    /**
     * 规格单价
     */
    @Column(name = "specs_price")
    private BigDecimal specsPrice;

    /**
     * 订单总金额
     */
    @Column(name = "order_amount", nullable = false)
    private BigDecimal orderAmount;

    /**
     * 支付状态，默认0未支付
     */
    @Column(name = "pay_status", nullable = false)
    private Integer payStatus;

    /**
     * 创建时间
     */
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

}
