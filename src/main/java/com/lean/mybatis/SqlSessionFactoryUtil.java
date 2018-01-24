/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lean.mybatis;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author huangwei
 */
public final class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private final static Class LOCK = SqlSessionFactoryUtil.class;
    
    private static final String MY_BATIS_CONF = "mybatis-config.xml";

    private static void initSqlSessionFactory() {
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(MY_BATIS_CONF);
        } catch (IOException e) {
            L.error("can not open cconfig {}", MY_BATIS_CONF);
        }
        synchronized (LOCK) {
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            }
        }
    }
    
    private SqlSessionFactoryUtil () {}
    
    public static SqlSession openSqlSession() {
        if (sqlSessionFactory == null) {
            initSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
    
    private final static Logger L = 
            LoggerFactory.getLogger(SqlSessionFactoryUtil.class);
}
