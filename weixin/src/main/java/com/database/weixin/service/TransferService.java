package com.database.weixin.service;

import com.database.weixin.entity.Transfer;
import java.util.List;

public interface TransferService {
    //插入员工调动信息
    boolean addTransfer(Transfer transfer);
}
