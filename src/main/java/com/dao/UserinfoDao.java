package com.dao;

import com.model.Userinfo;
import org.apache.ibatis.annotations.Param;

public interface UserinfoDao {
    int deleteByPrimaryKey(Integer userid);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);

    /**
     * 自定义方法
     */

    Boolean login(@Param("username") String username, @Param("password") String password);

    int loginGetPk(@Param("username") String username, @Param("password") String password);
}