package com.service;

import com.model.Killgoods;

import java.util.List;

public interface KillGoodsService {
    int deleteByPrimaryKey(Integer killid);

    int insert(Killgoods record);

    int insertSelective(Killgoods record);

    int updateByPrimaryKeySelective(Killgoods record);

    int updateByPrimaryKey(Killgoods record);


    /**
     *
     */
    List<Killgoods> listKillGoods();

    Killgoods selectByPrimaryKey(Integer killid);

    int subStockcount(Integer killid);
}
