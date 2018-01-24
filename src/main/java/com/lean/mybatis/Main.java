/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lean.mybatis;

import com.lean.bean.Tester;
import com.lean.mapper.TesterMapper;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author huangwei
 */
public class Main {
    public static void main(String[] args) {
        L.info("thread - {}", Thread.currentThread().getName());
        Main main = new Main();
        try {
            main.read();
        } catch (IOException e) {
        }
    }
    
    private void read () throws IOException {
        SqlSession sess = SqlSessionFactoryUtil.openSqlSession();
        try {
            Configuration conf = sess.getConfiguration();
            TesterMapper tm = sess.getMapper(TesterMapper.class);
            Tester t = tm.getTester(1L);
            L.info("tester {}", t);
        } finally {
            sess.close();
        }
    }
    
    private static final Logger L = LoggerFactory.getLogger(Main.class);
}
