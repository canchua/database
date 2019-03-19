package com.database.weixin.entity;

public class Logon {
    //员工编号
    private int employeeId;
    //登录密码
    private String password;
    //员工权限
    private int authority;

    public int getEmployeeId() {
        return employeeId;
    }


    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

}
