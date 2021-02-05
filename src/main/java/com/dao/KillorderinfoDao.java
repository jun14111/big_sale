package com.dao;

import com.model.Killorderinfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KillorderinfoDao {
    int deleteByPrimaryKey(Integer killorderid);

    int insert(Killorderinfo record);

    int insertSelective(Killorderinfo record);

    Killorderinfo selectByPrimaryKey(Integer killorderid);

    int updateByPrimaryKeySelective(Killorderinfo record);

    int updateByPrimaryKey(Killorderinfo record);

    /**
     * 自定义
     */

    List<Killorderinfo> selectByUseridAndKillid(@Param("userid") Integer userid, @Param("goodsid") Integer goodsid);
}