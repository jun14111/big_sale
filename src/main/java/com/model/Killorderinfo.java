package com.model;

import java.io.Serializable;
import lombok.Data;

/**
 * killorderinfo
 * @author 
 */
@Data
public class Killorderinfo implements Serializable {
    private Integer killorderid;

    private Integer userid;

    private Integer goodsid;

    private Integer orderid;

    private static final long serialVersionUID = 1L;
}