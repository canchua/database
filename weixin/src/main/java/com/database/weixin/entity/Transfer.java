package com.database.weixin.entity;

public class Transfer {
    //员工编号
    private int employeeId;

    //调动日期
    private int transDate;

    //调入部门ID
    private int inDepartment;

    //调出部门ID
    private int outDepartment;

    //调动原因
    private String reason;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getTransDate() {
        return transDate;
    }

    public void setTransDate(int transDate) {
        this.transDate = transDate;
    }

    public int getInDepartment() {
        return inDepartment;
    }

    public void setInDepartment(int inDepartment) {
        this.inDepartment = inDepartment;
    }

    public int getOutDepartment() {
        return outDepartment;
    }

    public void setOutDepartment(int outDepartment) {
        this.outDepartment = outDepartment;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
