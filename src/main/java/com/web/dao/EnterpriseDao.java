package com.web.dao;

import java.util.*;

import com.common.BaseDao;
import com.web.entity.RecordInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by sukey on 2016/7/7.
 */
@Repository
public class EnterpriseDao extends BaseDao {

    /**
     * 通过关键词查询企业信息
     *
     * @param keywords
     *
     * @return
     */
    public List<Map> findEnterpriseInfoByKeyWords(String keywords) {
        StringBuffer sql = new StringBuffer();
        sql.append("select t.username.t.com_name,t.role_type,t.reg_address,(select count(1) from DRAFT_PERMIT r where r.company_user=t.username ) as num From RECORD_INFO t where t.com_name like '%");
        sql.append(keywords);
        sql.append("%'");
        List<Map> enterpriseList = super.findResult(sql.toString(), new HashMap());

        return enterpriseList;
    }

    /**
     * 通过主键查询企业信息
     * @param id
     * @return
     */
    public List<RecordInfo> findEnterpriseInfoByID(String id){
        StringBuffer sql = new StringBuffer();
        sql.append("FROM RECORD_INFO t where t.username='");
        sql.append(id);
        sql.append("'");
        List<RecordInfo> enterpriseList = super.findObjects(sql.toString(),RecordInfo.class);
        return  enterpriseList;
    }



}
