package com.database.weixin.dao;

import com.database.weixin.entity.Logon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LogonDao {
    //用户登录
//    int login(Logon logon);
    int login(@Param("employeeId") int employeeId, @Param("password") String password);

    //新员工信息插入
    int insertLogon(Logon logon);

    //删除登录信息
    int deleteLogon(int employeeId);
}
