package com.database.weixin.service;

import com.database.weixin.entity.Logon;

import java.util.List;

public interface LogonService {
    //用户登录
//    Integer login(Logon logon);
    int login(int employeeId, String password);

    //增加新用户信息
    boolean addLogon(Logon logon);

    //删除登录信息
    boolean deleteLogon(int employeeId);
}
