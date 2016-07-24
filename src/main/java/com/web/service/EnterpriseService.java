package com.web.service;

import java.util.*;

import com.utils.DateUtil;
import com.utils.StringUtil;
import com.web.dao.EnterpriseDao;
import com.web.dao.RecordInfoDao;
import com.web.entity.RecordInfo;
import com.web.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sukey on 2016/7/8.
 */
@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseDao enterpriseDao;

    /**
     * 通过关键词查询企业信息
     *
     * @param keywords
     *
     * @return
     */
    public List<EnterpriseModel> findEnterpriseInfoByKeyWords(String keywords, String page, String pageSize) {
        int offset = 0;
        int limit = 10;
        if (pageSize != null && !"".equals(pageSize)) {
            limit = Integer.parseInt(pageSize);
        }
        if (page != null && !"".equals(page)) {
            offset = (Integer.parseInt(page) - 1) * limit;
        }
        List<Map> res_list = enterpriseDao.findEnterpriseInfoByKeyWords(keywords, limit, offset);
        List<EnterpriseModel> enterpriseModelList = new ArrayList<>();
        for (Map map : res_list) {
            EnterpriseModel model = new EnterpriseModel();
            model.setCom_name(StringUtil.safeToString(map.get("COM_NAME"), ""));
            String user_type = StringUtil.safeToString(map.get("USER_TYPE"), "");
            if ("10".equals(user_type)) {
                model.setRole_type("生产型企业或机构");
            } else if ("20".equals(user_type)) {
                model.setRole_type("经营型企业或机构");
            } else if ("30".equals(user_type)) {
                model.setRole_type("服务型企业或机构");
            } else if ("50".equals(user_type)) {
                model.setRole_type("企业或机构消费者");
            } else if ("60".equals(user_type)) {
                model.setRole_type("个人消费者");
            }

            model.setReg_address(StringUtil.safeToString(map.get("REG_ADDRESS"), ""));
            model.setProduct_num(StringUtil.safeToString(map.get("NUM"), ""));
            model.setEid(StringUtil.safeToString(map.get("USERNAME"), ""));
            model.setRecord_no(StringUtil.safeToString(map.get("RECORD_NO"), ""));
            enterpriseModelList.add(model);
        }
        return enterpriseModelList;
    }

    /**
     * 通过主键查询企业信息
     *
     * @param id
     *
     * @return
     */
    public List<RecordInfo> findEnterpriseInfoByID(String id) {
        List<RecordInfo> recordInfoList = enterpriseDao.findEnterpriseInfoByID(id);
        return recordInfoList;
    }

    /**
     * 通过RECORD_ID 查询企业许可证
     *
     * @param record_no
     *
     * @return
     */
    public List<CertificateModel> findCertificateByRecordNo(String record_no) {
        List<Map> res_list = enterpriseDao.findCertificateByRecordNo(record_no);
        List<CertificateModel> models = new ArrayList<>();
        for (Map map : res_list) {
            CertificateModel model = new CertificateModel();
            model.setCertificate_name(StringUtil.safeToString(map.get("CERTIFICATE_NAME"), ""));
            model.setCertificateNo("");
            model.setIssue_branch(StringUtil.safeToString(map.get("ISSUE_BRANCH"), ""));
            model.setValid_period(StringUtil.safeToString(map.get("VALID_PERIOD"), ""));
            model.setPermit_name(StringUtil.safeToString(map.get("PERMIT_NAME"), ""));
            model.setIssue_date(StringUtil.safeToString(map.get("ISSUE_DATE"), ""));
            models.add(model);
        }
        return models;
    }

    /**
     * @param userid
     * @param page
     * @param pageSize
     *
     * @return
     */
    public List<EnterpriseModel> findCollectdEnterpriseInfo(String userid, String keywords, String page, String pageSize) {
        int offset = 0;
        int limit = 10;
        if (pageSize != null && !"".equals(pageSize)) {
            limit = Integer.parseInt(pageSize);
        }
        if (page != null && !"".equals(page)) {
            offset = (Integer.parseInt(page) - 1) * limit;
        }
        List<Map> res_list = enterpriseDao.findCollectedEnterpriseInfo(userid, keywords, limit, offset);
        List<EnterpriseModel> enterpriseModelList = new ArrayList<>();
        for (Map map : res_list) {
            EnterpriseModel model = new EnterpriseModel();
            model.setCom_name(StringUtil.safeToString(map.get("COM_NAME"), ""));
            String user_type = StringUtil.safeToString(map.get("USER_TYPE"), "");
            if ("10".equals(user_type)) {
                model.setRole_type("生产型企业或机构");
            } else if ("20".equals(user_type)) {
                model.setRole_type("经营型企业或机构");
            } else if ("30".equals(user_type)) {
                model.setRole_type("服务型企业或机构");
            } else if ("50".equals(user_type)) {
                model.setRole_type("企业或机构消费者");
            } else if ("60".equals(user_type)) {
                model.setRole_type("个人消费者");
            }

            model.setReg_address(StringUtil.safeToString(map.get("REG_ADDRESS"), ""));
            model.setProduct_num(StringUtil.safeToString(map.get("NUM"), ""));
            model.setEid(StringUtil.safeToString(map.get("USERNAME"), ""));
            model.setRecord_no(StringUtil.safeToString(map.get("RECORD_NO"), ""));
            enterpriseModelList.add(model);
        }
        return enterpriseModelList;
    }


}
