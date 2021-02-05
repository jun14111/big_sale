package com.service.impl;

import com.dao.KillgoodsDao;
import com.model.Killgoods;
import com.service.KillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("killGoodsService")
public class KillGoodsServiceImpl implements KillGoodsService {
    @Autowired
    KillgoodsDao killgoodsDao;

    @Override
    public int deleteByPrimaryKey(Integer killid) {
        return killgoodsDao.deleteByPrimaryKey(killid);
    }

    @Override
    public int insert(Killgoods record) {
        return killgoodsDao.insert(record);
    }

    @Override
    public int insertSelective(Killgoods record) {
        return killgoodsDao.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Killgoods record) {
        return killgoodsDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Killgoods record) {
        return killgoodsDao.updateByPrimaryKey(record);
    }

    /**
     * 自定义
     */

    @Override
    public List<Killgoods> listKillGoods() {
        return killgoodsDao.listKillGoods();
    }

    @Override
    public Killgoods selectByPrimaryKey(Integer killid) {
        return killgoodsDao.selectByPrimaryKey(killid);
    }

    @Override
    public int subStockcount(Integer killid) {
        return killgoodsDao.subStockcount(killid);
    }


}
