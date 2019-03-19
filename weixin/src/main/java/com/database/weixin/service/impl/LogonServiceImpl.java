package com.database.weixin.service.impl;

import com.database.weixin.dao.LogonDao;
import com.database.weixin.entity.Employee;
import com.database.weixin.entity.Logon;
import com.database.weixin.service.LogonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Component
public class LogonServiceImpl implements LogonService {

    @Autowired
    private LogonDao logonDao;

//    @Transactional
//    @Override
//    public Integer login(Logon logon){
//        if(logon.getEmployeeId() != null && !"".equals(logon.getEmployeeId())) {
//            if (logon.getPassword() != null && !"".equals(logon.getPassword())) {
//                try {
//
//                    int effectedNum = logonDao.login(logon);
//
//                    if (effectedNum > 0)
//                        return logon.getAuthority();
//                    else
//                        throw new RuntimeException("用户名或密码错误！");
//                } catch (Exception e) {
//                    throw new RuntimeException("用户名或密码错误：" + e.getMessage());
//                }
//            } else {
//                throw new RuntimeException("密码不能为空！");
//            }
//        } else {
//            throw new RuntimeException("用户名不能为空！");
//        }
//
//    }
    @Override
    public int login(int employeeId, String password){
        String id="";
        id = employeeId + "";
        if(id != null && !"".equals(id)) {
            if (password != null && !"".equals(password)) {
                try {

                    int effectedNum = logonDao.login(employeeId, password);

                    if (effectedNum > 0)
                        return effectedNum;
                    else
                        throw new RuntimeException("账号或密码错误！");
                } catch (Exception e) {
                    throw new RuntimeException("账号或密码错误：" + e.getMessage());
                }
            } else {
                throw new RuntimeException("密码不能为空！");
            }
        } else {
            throw new RuntimeException("登录账号不能为空！");
        }

    }

    @Transactional
    @Override
    public boolean addLogon(Logon logon) {
        if (logon.getEmployeeId() != 0 && !"".equals(logon.getEmployeeId())) {
            try {
                int effectedNum = logonDao.insertLogon(logon);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入员工信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入员工信息失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("员工信息不能为空！");
        }
    }


    @Override
    public boolean deleteLogon(int employeeId) {
        if (employeeId > 0) {
            try {
                int effectedNum = logonDao.deleteLogon(employeeId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除员工登录信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除员工登录信息失败：" + e.toString());
            }
        } else {
            throw new RuntimeException("员工Id不能为空！");
        }
    }
}
