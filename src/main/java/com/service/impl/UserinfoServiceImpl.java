package com.service.impl;

import com.dao.UserinfoDao;
import com.model.Killgoods;
import com.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userinfoService")
public class UserinfoServiceImpl implements UserinfoService {
    @Autowired
    UserinfoDao userinfoDao;

    @Override
    public Boolean login(String username, String password) {
        return userinfoDao.login(username, password);
    }

    @Override
    public int loginGetPk(String username, String password) {
        return userinfoDao.loginGetPk(username, password);
    }
}
