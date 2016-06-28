package com.web.service;

import com.web.dao.DemoDao;
import com.web.dao.ReportDao;
import com.web.entity.Demo;
import com.web.entity.ReportCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by gaoyang on 16/2/29.
 */
@Service("reportService")
public class ReportService {

    @Autowired
    public ReportDao reportDao;

    public void saveReport(ReportCompany reportCompany){
        reportDao.save(reportCompany);
    }
}
