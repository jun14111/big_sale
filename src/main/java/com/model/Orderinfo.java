package com.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * orderinfo
 * @author 
 */
@Data
public class Orderinfo implements Serializable {
    private Integer orderid;

    private Integer userid;

    private Integer goodsid;

    private String goodsname;

    private Integer goodscount;

    private Integer goodsprice;

    private Integer orderstatus;

    private Date createdate;

    private Date paydate;

    private static final long serialVersionUID = 1L;
}