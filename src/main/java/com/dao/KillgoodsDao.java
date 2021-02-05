package com.dao;

import com.model.Killgoods;

import java.util.List;

public interface KillgoodsDao {
    int deleteByPrimaryKey(Integer killid);

    int insert(Killgoods record);

    int insertSelective(Killgoods record);

    int updateByPrimaryKeySelective(Killgoods record);

    int updateByPrimaryKey(Killgoods record);

    /**
     * 自定义方法
     */

    List<Killgoods> listKillGoods();

    Killgoods selectByPrimaryKey(Integer killid);

    int subStockcount(Integer killid);
}