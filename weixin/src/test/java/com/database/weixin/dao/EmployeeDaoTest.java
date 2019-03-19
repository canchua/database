package com.database.weixin.dao;

import com.database.weixin.entity.Employee;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDaoTest {
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    @Ignore
    public void queryEmployee() {
        List<Employee> employeeList = employeeDao.queryEmployee();
        assertEquals(16, employeeList.size());
    }

    @Test
    @Ignore
    public void queryEmployeeById() {
        Employee employee = employeeDao.queryEmployeeById(1);
        assertEquals("阿尔托利亚", employee.getEmployeeName());
    }

    @Test
    @Ignore
    public void insertEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName("hhh");
        int effectedNum = employeeDao.insertEmployee(employee);
        assertEquals(1, effectedNum);
    }

    @Test
    @Ignore
    public void updateEmployee() {
        Employee employee = new Employee();
        employee.setEmployeeName("hello");
        employee.setEmployeeId(33);
        employee.setJoinTime(2018);
        int effectedNum = employeeDao.updateEmployee(employee);
        assertEquals(1, effectedNum);
    }

    @Test
    @Ignore
    public void deleteEmployee() {
        int effectedNum = employeeDao.deleteEmployee(33);
        assertEquals(1, effectedNum);
    }
}