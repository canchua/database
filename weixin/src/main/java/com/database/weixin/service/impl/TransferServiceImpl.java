package com.database.weixin.service.impl;

import com.database.weixin.dao.TransferDao;
import com.database.weixin.entity.Employee;
import com.database.weixin.entity.Transfer;
import com.database.weixin.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    private TransferDao transferDao;


    @Transactional
    @Override
    public boolean addTransfer(Transfer transfer) {
        if (transfer.getEmployeeId() != 0 && !"".equals(transfer.getEmployeeId())) {
            try {
                int effectedNum = transferDao.insertTransfer(transfer);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入员工调动信息失败！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入员工调动信息失败：" + e.getMessage());
            }
        } else {
            throw new RuntimeException("员工调动信息不能为空！");
        }
    }

}
