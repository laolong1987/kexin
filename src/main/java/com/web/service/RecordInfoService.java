package com.web.service;

import com.web.dao.DemoDao;
import com.web.dao.RecordInfoDao;
import com.web.entity.Demo;
import com.web.entity.RECORD_INFO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by gaoyang on 16/2/29.
 */
@Service("recordInfoService")
public class RecordInfoService {

    @Autowired
    public RecordInfoDao recordInfoDao;

    public List<RECORD_INFO> searchRECORD_INFO(Map map){
        return recordInfoDao.searchRECORD_INFO(map);
    }
}
