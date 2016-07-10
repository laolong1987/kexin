package com.web.service;

import java.util.*;

import com.utils.DateUtil;
import com.utils.StringUtil;
import com.web.dao.EnterpriseDao;
import com.web.entity.RecordInfo;
import com.web.model.EnterpriseDetailModel;
import com.web.model.EnterpriseModel;
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
    public List<EnterpriseModel> findEnterpriseInfoByKeyWords(String keywords) {
        List<Map> res_list = enterpriseDao.findEnterpriseInfoByKeyWords(keywords);
        List<EnterpriseModel> enterpriseModelList = new ArrayList<>();
        for (Map map : res_list) {
            EnterpriseModel model = new EnterpriseModel();
            model.setCom_name(StringUtil.safeToString(map.get("COM_NAME"), ""));
            String role_type = StringUtil.safeToString(map.get("ROLE_TYPE"), "");
            model.setRole_type(role_type);
            model.setReg_address(StringUtil.safeToString(map.get("REG_ADDRESS"), ""));
            model.setProduct_num(StringUtil.safeToString(map.get("NUM"), ""));
            model.setProduct_num(StringUtil.safeToString(map.get("USERNAME"), ""));
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
    public EnterpriseDetailModel findEnterpriseInfoByID(String id) {
        List<RecordInfo> recordInfoList=enterpriseDao.findEnterpriseInfoByID(id);
        EnterpriseDetailModel model =new EnterpriseDetailModel();
        if(recordInfoList.size()>0){
            RecordInfo recordInfo=recordInfoList.get(0);
            model.setReg_address(recordInfo.getReg_address());
            model.setCom_name(recordInfo.getCom_name());
            model.setRole_type(recordInfo.getRole_type());
            model.setAddress(recordInfo.getAddress());
            model.setAnnual_check(recordInfo.getAnnual_check());
            model.setFound_date(DateUtil.FormatUIDate(recordInfo.getFound_date()));
            model.setIs_manu_import(recordInfo.getIs_manu_import());
            model.setLaw_person(recordInfo.getLaw_person());
            model.setLp_phone(recordInfo.getLp_phone());
            model.setReg_branch(recordInfo.getReg_branch());
            model.setReg_capital(recordInfo.getReg_capital());
            model.setReg_on(recordInfo.getReg_no());
            model.setValid_period(DateUtil.FormatUIDate(recordInfo.getValid_period()));
        }
        return model;
    }
}