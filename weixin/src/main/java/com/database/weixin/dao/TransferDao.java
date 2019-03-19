package com.database.weixin.dao;

import com.database.weixin.entity.Transfer;

import java.util.List;

public interface TransferDao {
    //插入员工调动信息
    int insertTransfer(Transfer transfer);
}
