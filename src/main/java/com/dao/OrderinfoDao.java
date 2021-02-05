package com.dao;

import com.model.Orderinfo;

import java.util.List;

public interface OrderinfoDao {
    int deleteByPrimaryKey(Integer orderid);

    int insert(Orderinfo record);

    int insertSelective(Orderinfo record);

    Orderinfo selectByPrimaryKey(Integer orderid);

    int updateByPrimaryKeySelective(Orderinfo record);

    int updateByPrimaryKey(Orderinfo record);

    /**
     * 自定义
     */

    List<Orderinfo> listOrderinfoByUserid(Integer userid);
}