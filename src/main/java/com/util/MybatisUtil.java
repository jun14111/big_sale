package com.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtil {
    public static SqlSessionFactory factory = null;
    public static SqlSession session = null;

    static {
        try {
            // 实现获得session
            Reader r = Resources.getResourceAsReader("mybatis-config.xml");
            // 创建session工厂
            factory = new SqlSessionFactoryBuilder().build(r);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取session
    public static void getSession() {
        session = factory.openSession();
    }

    /**
     * 关闭资源
     */
    public static void close() {
        if (session != null) {
            session.close();
        }
    }

}
