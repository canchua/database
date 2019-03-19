package com.database.weixin.web;

import com.database.weixin.entity.Logon;
import com.database.weixin.entity.Transfer;
import com.database.weixin.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    private TransferService transferService;

    @RequestMapping(value = "/addtransfer", method = RequestMethod.POST)

    private Map<String, Object> addTransfer(@RequestBody Transfer transfer){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //System.out.println("transfer:" + transfer.getEmployeeId());
        modelMap.put("success", transferService.addTransfer(transfer));
        System.out.println("transfer:" + transfer.getEmployeeId());
        return modelMap;
    }
}
