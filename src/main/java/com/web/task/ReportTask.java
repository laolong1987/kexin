package com.web.task;

import com.web.service.RecordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by gaoyang on 16/7/4.
 */
@Component("reportTask")
public class ReportTask {


    @Autowired
    RecordInfoService recordInfoService;


//    @Scheduled(cron = "0 0 */1 * * ?")
    @Scheduled(cron = "0 */1 * * * ?")
    public void sendsms() {
        //每天23点执行
        System.out.println("task---------sendsms-----start");
        recordInfoService.runremindesms();
        System.out.println("task---------sendsms-----end");
    }
}
