package com.database.weixin.dao;


import com.database.weixin.entity.Logon;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogonDaoTest {
    @Autowired
    private LogonDao logonDao;

    @Test
    @Ignore
    public void login(){
        Logon logon = new Logon();
    }
}
