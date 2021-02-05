package com.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * killgoods
 *
 * @author
 */
@Data
public class Killgoods implements Serializable {
    private Integer killid;

    private Integer goodsid;

    private Integer stockcount;

    private Date startdate;

    private Date enddate;

    private Integer killprice;

    private static final long serialVersionUID = 1L;

    /**
     * 商品基本信息
     */
    private String goodsName;
    private String goodsImg;
    private String goodsContent;
    private Double goodsPrice;
}