package com.database.weixin.service.impl;

import com.database.weixin.dao.EmployeeDao;
import com.database.weixin.entity.Employee;
import com.database.weixin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getEmployeeList() {
        return employeeDao.queryEmployee();
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        return employeeDao.queryEmployeeById(employeeId);
    }

    @Transactional
    @Override
    public boolean addEmployee(Employee employee) {
        if (employee.getEmployeeName() != null && !"".equals(employee.getEmployeeName())) {
            try {
                int effectedNum = employeeDao.insertEmployee(employee);
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
    public boolean modifyEmployee(Employee employee) {
        String id="";
        id = employee.getEmployeeId() + "";
        if (id != null && !"".equals(id)) {
            try {
                int effectedNum = employeeDao.updateEmployee(employee);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新员工信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新员工信息失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("更新信息不能为空！");
        }
    }

    @Override
    public boolean mobilizeEmployee(Employee employee) {
        String id="";
        id = employee.getEmployeeId() + "";
        if (id != null && !"".equals(id)) {
            try {
                int effectedNum = employeeDao.transferEmployee(employee);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("员工调动失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("员工调动失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("调动信息不能为空！");
        }
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        if (employeeId > 0) {
            try {
                int effectedNum = employeeDao.deleteEmployee(employeeId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除员工信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除员工信息失败：" + e.toString());
            }
        } else {
            throw new RuntimeException("员工Id不能为空！");
        }
    }
}
