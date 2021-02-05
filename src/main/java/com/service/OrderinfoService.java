package com.service;

import com.model.Orderinfo;

import java.util.List;

public interface OrderinfoService {
    int insertSelective(Orderinfo record);

    List<Orderinfo> listOrderinfoByUserid(Integer userid);
}
