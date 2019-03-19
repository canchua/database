package com.database.weixin.dao;

import com.database.weixin.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {
    /*
    列出员工列表
    @return employeeList
     */
    List<Employee> queryEmployee();

    /*
    根据Id列出具体员工
    @return employee
     */
    Employee queryEmployeeById(@Param("employeeId") int employeeId);

    /*
    插入员工信息
    @param employee
    @return
     */
    int insertEmployee(Employee employee);

    /*
    更新员工信息
    @param employee
    @return
     */
    int updateEmployee(Employee employee);

    //员工调动
    int transferEmployee(Employee employee);

    /*
    删除员工信息
    @param employee
    @return
     */
    int deleteEmployee(int employeeId);
}
