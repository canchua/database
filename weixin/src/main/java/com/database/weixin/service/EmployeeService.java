package com.database.weixin.service;

import com.database.weixin.entity.Employee;

import java.util.List;

public interface EmployeeService {
    /*
        获取员工列表
        @return
         */
    List<Employee> getEmployeeList();

    /*
    根据Id获取员工信息
    @param employeeId
    @return employee
     */
    Employee getEmployeeById(int employeeId);

    /*
    增加员工信息
    @param employee
    @return
     */
    boolean addEmployee(Employee employee);

    /*
    修改员工信息
    @param employee
    @return
     */
    boolean modifyEmployee(Employee employee);

    //员工调动
    boolean mobilizeEmployee(Employee employee);

    /*
    删除员工信息
    @param employee
    @return
     */
    boolean deleteEmployee(int employeeId);
}
