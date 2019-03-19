package com.database.weixin.web;

import com.database.weixin.entity.Employee;
import com.database.weixin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/listemployee", method = RequestMethod.GET)
//    使用map容器返回数据信息
    private Map<String, Object> listEmployee() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Employee> list = employeeService.getEmployeeList();
        modelMap.put("employeeList", list);
        return modelMap;
    }

    @RequestMapping(value = "/getemployeebyid", method = RequestMethod.GET)
    private Map<String, Object> getEmployeeById(@RequestParam(value = "employeeId") int employeeId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        Employee employee = employeeService.getEmployeeById(employeeId);
        modelMap.put("employee", employee);
        System.out.println("employeeId --> " + employeeId);
        return modelMap;
    }

    @RequestMapping(value = "/addemployee", method = RequestMethod.POST)
    private Map<String, Object> addEmployee(@RequestBody Employee employee){
        System.out.println("----try----");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        System.out.println("employee:" + employee.getEmployeeId());
        modelMap.put("success", employeeService.addEmployee(employee));
        return modelMap;
    }

    @RequestMapping(value = "/modifyemployee", method = RequestMethod.GET)
    private Map<String, Object> modifyEmployee(@RequestBody Employee employee) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", employeeService.modifyEmployee(employee));
        return modelMap;
    }

    @RequestMapping(value = "/mobilizeemployee", method = RequestMethod.GET)
    private Map<String, Object> mobilizeEmployee(@RequestBody Employee employee) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", employeeService.mobilizeEmployee(employee));
        return modelMap;
    }

    @RequestMapping(value = "/removeemployee", method = RequestMethod.GET)
    private Map<String, Object> removeEmployee(int employeeId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", employeeService.deleteEmployee(employeeId));
        return modelMap;
    }

}
