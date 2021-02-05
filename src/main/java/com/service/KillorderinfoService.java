package com.service;

import com.model.Killorderinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KillorderinfoService {
    List<Killorderinfo> selectByUseridAndKillid(@Param("userid") Integer userid, @Param("goodsid") Integer goodsid);

    int insertSelective(Killorderinfo record);
}
