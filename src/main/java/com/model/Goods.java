package com.model;

import java.io.Serializable;
import lombok.Data;

/**
 * goods
 * @author huangcj
 */
@Data
public class Goods implements Serializable {
    private Integer goodsid;

    private String goodsname;

    private String goodsimg;

    private String goodscontent;

    private Integer goodsprice;

    private Integer goodsstock;

    private static final long serialVersionUID = 1L;
}