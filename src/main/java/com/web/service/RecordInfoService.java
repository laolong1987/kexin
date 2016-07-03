package com.web.service;

import com.common.SearchTemplate;
import com.web.dao.RecordInfoDao;
import com.web.entity.*;
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


    public List<Map<String, Object>> searchReportProduct(Map map){
        return recordInfoDao.searchReportProduct(map).getValues();
    }

    public List<Map<String, Object>> searchReportCompany(Map map){
        return recordInfoDao.searchReportCompany(map).getValues();
    }

    public SearchTemplate findReportCompany(Map map){
        return recordInfoDao.searchReportCompany(map);
    }

    public SearchTemplate findReportProduct(Map map){
        return recordInfoDao.searchReportProduct(map);
    }


    public ReportProduct getReportProduct(String id){
        return (ReportProduct) recordInfoDao.getObjectById(id,ReportProduct.class);
    }


    public ReportCompany getReportCompany(String id){
        return (ReportCompany) recordInfoDao.getObjectById(id,ReportCompany.class);
    }

    public List<ReportHandle> findreporthandle(String reportid, int reporttype){
        return recordInfoDao.findreporthandle(reportid,reporttype);
    }

    public  void saveReportHandle(ReportHandle reportHandle){
        recordInfoDao.save(reportHandle);
    }

    public  ReportHandle getReportHandle(String id ){
        return  (ReportHandle) recordInfoDao.getObjectById(id,ReportHandle.class);
    }

    /**
     * 查询
     *
     * @return
     */
    public ReportReminder findReportReminder(String userid){
        List<ReportReminder> list=recordInfoDao.findReportReminder(userid);
        if(list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }

    public  void savereportReminder(ReportReminder reportReminder){
        recordInfoDao.save(reportReminder);
    }



}
