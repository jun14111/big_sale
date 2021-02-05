package com.service;

import com.model.Killgoods;
import org.apache.ibatis.annotations.Param;

public interface UserinfoService {
    Boolean login(String username, String password);

    int loginGetPk(String username, String password);
}
