package com.database.weixin.entity;

public class Employee {
    // 员工编号
    private int employeeId;
    // 员工姓名
    private String employeeName;
    // 员工状态
    private String employeeState;
    // 到岗日期
    private int joinTime;
    // 职务
    private String job;
    // 所在部门编号
    private int departmentId;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeState() {
        return employeeState;
    }

    public void setEmployeeState(String employeeState) {
        this.employeeState = employeeState;
    }

    public int getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(int joinTime) {
        this.joinTime = joinTime;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
