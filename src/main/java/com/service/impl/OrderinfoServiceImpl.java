package com.service.impl;

import com.dao.OrderinfoDao;
import com.model.Orderinfo;
import com.service.OrderinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderinfoServiceImpl")
public class OrderinfoServiceImpl implements OrderinfoService {
    @Autowired
    OrderinfoDao orderinfoDao;

    @Override
    public int insertSelective(Orderinfo record) {
        return orderinfoDao.insertSelective(record);
    }

    @Override
    public List<Orderinfo> listOrderinfoByUserid(Integer userid){
        return orderinfoDao.listOrderinfoByUserid(userid);
    }
}
