package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品规格表
 */
@Data
@Entity
@Table(name = "phone_specs")
public class PhoneSpecs implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "specs_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer specsId;

    @Column(name = "phone_id", nullable = false)
    private String phoneId;

    /**
     * 规格名称
     */
    @Column(name = "specs_name", nullable = false)
    private String specsName;

    /**
     * 库存
     */
    @Column(name = "specs_stock", nullable = false)
    private Integer specsStock;

    /**
     * 单价
     */
    @Column(name = "specs_price", nullable = false)
    private BigDecimal specsPrice;

    /**
     * 小图
     */
    @Column(name = "specs_icon")
    private String specsIcon;

    /**
     * 预览图
     */
    @Column(name = "specs_preview")
    private String specsPreview;

    /**
     * 修改时间
     */
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time", nullable = false)
    private Date createTime;

}
