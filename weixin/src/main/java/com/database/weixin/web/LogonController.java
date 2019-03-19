package com.database.weixin.web;

import com.database.weixin.entity.Employee;
import com.database.weixin.entity.Logon;
import com.database.weixin.service.LogonService;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/logon")
public class LogonController {
//    @Autowired
//    private Logon logon;

    @Autowired
    private LogonService logonService;

//    @RequestMapping(value = "/userauthority", method = RequestMethod.GET)
//    private Map<String, Integer> userAuthority() {
//        Map<String, Integer> modelMap = new HashMap<String, Integer>();
//        Integer authority = logon.getAuthority();
//        modelMap.put("userAuthority", authority);
//        return modelMap;
//    }
//    @RequestMapping(value = "/userauthority", method = RequestMethod.GET)
//    private Integer userAUthority (Integer username, String password) {
//        logon.setEmployeeId(username);
//        logon.setPassword(password);
//        Integer authority = logonService.login(logon);
//        return authority;
//    }

    @RequestMapping(value = "/userauthority", method = RequestMethod.GET)
    private int userAUthority (@RequestParam(value = "employeeId") int employeeId, @RequestParam(value = "passWord") String password) {
        int authority = logonService.login(employeeId, password);
        System.out.println("employeeId:" + employeeId);
        System.out.println("password:" + password);
        System.out.println("authority:" + authority);
        return authority;
    }

    @RequestMapping(value = "/addlogon", method = RequestMethod.POST)

    private Map<String, Object> addLogon(@RequestBody Logon logon){
        System.out.println("----try----");
        Map<String, Object> modelMap = new HashMap<String, Object>();
        System.out.println("logon:" + logon.getEmployeeId());
        modelMap.put("success", logonService.addLogon(logon));
        return modelMap;
    }

    @RequestMapping(value = "/removelogon", method = RequestMethod.GET)
    private Map<String, Object> removeLogon(int employeeId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", logonService.deleteLogon(employeeId));
        return modelMap;
    }
}
