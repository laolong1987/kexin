package com.web.service;

import com.web.dao.RecordInfoDao;
import com.web.entity.RecordInfo;
import com.web.entity.ReportCompany;
import com.web.entity.ReportProduct;
import com.web.model.ReportProductVO;
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

    public List<Map> searchRECORD_INFO(Map map){
        return recordInfoDao.searchRECORD_INFO(map);
    }

    public RecordInfo getRecordInfoById(int id){
        return (RecordInfo) recordInfoDao.getObjectById(id,RecordInfo.class);
    }

    public void saveReportProduct(ReportProduct reportProduct){
        recordInfoDao.save(reportProduct);
    }

    public void saveReportCompany(ReportCompany reportCompany){
        recordInfoDao.save(reportCompany);
    }


    public List<Map> searchReportProduct(Map map){
        return recordInfoDao.searchReportProduct(map);
    }

    public ReportProduct getReportProduct(String id){
        return (ReportProduct) recordInfoDao.getObjectById(id,ReportProduct.class);
    }

    public ReportCompany getReportCompany(String id){
        return (ReportCompany) recordInfoDao.getObjectById(id,ReportCompany.class);
    }

}
