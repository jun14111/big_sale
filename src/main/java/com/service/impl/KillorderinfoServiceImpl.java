package com.service.impl;

import com.dao.KillgoodsDao;
import com.dao.KillorderinfoDao;
import com.model.Killorderinfo;
import com.service.KillorderinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("killorderinfoService")
public class KillorderinfoServiceImpl implements KillorderinfoService {
    @Autowired
    KillorderinfoDao killorderinfoDao;

    @Override
    public List<Killorderinfo> selectByUseridAndKillid(Integer userid, Integer goodsid) {
        return killorderinfoDao.selectByUseridAndKillid(userid, goodsid);
    }

    @Override
    public int insertSelective(Killorderinfo record) {
        return killorderinfoDao.insertSelective(record);
    }
}
