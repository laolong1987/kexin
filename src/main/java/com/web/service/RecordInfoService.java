package com.web.service;

import com.common.MailSender;
import com.common.SearchTemplate;
import com.utils.ConvertUtil;
import com.utils.DateUtil;
import com.web.component.mail.SentEmailUtils;
import com.web.component.message.MessageSenderImpl;
import com.web.dao.RecordInfoDao;
import com.web.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


/**
 * Created by gaoyang on 16/2/29.
 */
@Service("recordInfoService")
public class RecordInfoService {

    @Autowired
    public RecordInfoDao recordInfoDao;

    @Autowired
    public MailSender mailSender;

    @Autowired
    private MessageSenderImpl messageSender;

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

    public void saveProductComment(ProductComment productComment){
        recordInfoDao.save(productComment);
    }

    public void saveCollect(Collect collect){
        recordInfoDao.save(collect);
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

    public DraftPermit getProduct(String id ){
        return  (DraftPermit) recordInfoDao.getObjectById(id,DraftPermit.class);
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


    private static String TITLE="你有一个举报要处理";
    private static String CONTENT="你有一个举报要处理";

    public void runreminde(){
        List<ReportReminder> list=recordInfoDao.findReportReminder();
        for (ReportReminder remider:list ) {
            if(null!=remider.getEmail() && !"".equals(remider.getEmail())){
                try {
                    SentEmailUtils.sentEmailNullFile(remider.getEmail(),TITLE,CONTENT);
//                    mailSender.batchSend(TITLE,CONTENT,false,remider.getEmail());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(null!=remider.getPhone() && !"".equals(remider.getPhone())){
                if(reportRules(remider.getDay(),remider.getTime())){
                    //发送短信
                    messageSender.batchSend(CONTENT, remider.getPhone());
                }else{
                    //保存到数据库
                    ReportSms sms=new ReportSms();
                    sms.setCreate_time(new Date());
                    sms.setUpdate_time(new Date());
                    sms.setUser_id(remider.getUser_id());
                    sms.setStatus(0);
                    recordInfoDao.save(sms);
                }
            }
        }
    }

    @Transactional
    public void runremindesms(){
       List<Map> list= recordInfoDao.searchReportSMS();
        Map<String,Integer> sendmap=new HashMap<>();
        List<String> dellist=new ArrayList<>();
        for (Map map:list) {
            String phone= ConvertUtil.safeToString(map.get("PHONE"),"");
            String id= ConvertUtil.safeToString(map.get("ID"),"");
            int time= ConvertUtil.safeToInteger(map.get("TIME"),1);
            int day= ConvertUtil.safeToInteger(map.get("DAY"),1);
            if(null!=phone && !"".equals(phone)){
                if(reportRules(day,time)){
                    //发送短信
                    if(sendmap.containsKey(phone)){
                        int a=sendmap.get(phone)+1;
                        sendmap.put(phone,a) ;
                    }else{
                        sendmap.put(phone,1) ;
                    }
                    dellist.add(id);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : sendmap.entrySet()) {
            //发送短信
            messageSender.batchSend("你有"+entry.getValue()+"个举报要处理", entry.getKey());
        }

        for(String s:dellist){
            ReportSms sms= (ReportSms)recordInfoDao.getObjectById(s,ReportSms.class);
            sms.setStatus(1);
            recordInfoDao.save(sms);
        }

    }

    public boolean  reportRules(int day,int time){
        boolean result=true;// 默认当前时间是可以发送的
        if(!isday(day) || !istime(time)){
            result=false;
        }
        return result;
    }

    public boolean isday(int day){
        boolean result=true;
        if(2==day){
            int a = DateUtil.getNumofWeek();
            if(2==a || 3==a || 4==a ||5==a ||6==a ){
                result=true;
            }else{
                result=false;
            }
        }
        return result;
    }


    public boolean istime(int time){
        String m = "00";
        String h = "";
        boolean result=true;
        if(1!=time){
            if(2==time){
                result= DateUtil.checkTimes2("09"+":00","18"+":00");
            }else if(3==time){
                result= DateUtil.checkTimes2("09"+":00","17"+":00");
            }else if(4==time){
                result= DateUtil.checkTimes2("08"+":00","18"+":00");
            }else if(5==time){
                result= DateUtil.checkTimes2("08"+":00","17"+":00");
            }
        }
        return result;
    }

    /**
     * 查询
     *
     * @return
     */
    public ReportProductCode findReportProductCode(String code){
        ReportProductCode reportProductCode=null;
        List<ReportProductCode> list=recordInfoDao.findReportProductCode(code);
        if(list.size()>0){
            reportProductCode=list.get(0);
        }
        return reportProductCode;
    }

    public List<Map> findProduct(Map map){
       return recordInfoDao.findProduct(map);
    }
    public List<Map> findProductCollect(Map map){
        return recordInfoDao.findProductCollect(map);
    }

    public List<Map> findLicense(String companyname){
        return recordInfoDao.findLicense(companyname);
    }

    public List<ProductComment> findProductComment(String productid){
        return recordInfoDao.findProductComment(productid);
    }

    public List<Map> findProductComment2(String productid){
        return recordInfoDao.findProductComment2(productid);
    }

    public List<Map> findWebSite(String draft_id){
        return recordInfoDao.findWebSite(draft_id);
    }
    public String getProductCommentpoint(String productid){
        return recordInfoDao.getProductCommentpoint(productid);
    }

    public void removeCollect(String userid,String sourceid,int type){
        String sql=new String("delete from collect where type=:type and sourceid=:sourceid and userid=:userid");
        Map map=new HashMap();
        map.put("userid",userid);
        map.put("sourceid",sourceid);
        map.put("type",type);
        recordInfoDao.executeSql(sql,map);
    }

    public String findCollect(String sourceid,int type,String userid){
        return findCollect(sourceid,type,userid);
    }
}
