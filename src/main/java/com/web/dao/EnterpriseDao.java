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
    public List<Map> findEnterpriseInfoByKeyWords(String keywords, int limit, int offset) {
        StringBuffer sql = new StringBuffer();
        sql.append("select W.*,(select count(1) from DRAFT_PERMIT r where  W.username=r.company_user ) as num from (");
        sql.append(" select * from (select t.username,t.record_no,t.com_name,t.user_type,t.reg_address,ROWNUM as RN From RECORD_INFO t where 1=1 ");

        if (!"".equals(keywords) && keywords != null) {
            sql.append(" and t.com_name like '%");
            sql.append(keywords);
            sql.append("%'");
        }
        sql.append(" ) where RN> ");
        sql.append(offset);
        sql.append(" and RN<=");
        sql.append(offset + limit);
        sql.append(") W");

        List<Map> enterpriseList = super.findResult(sql.toString(), new HashMap());

        return enterpriseList;
    }

    /**
     * 通过主键查询企业信息
     *
     * @param id
     *
     * @return
     */
    public List<RecordInfo> findEnterpriseInfoByID(String id) {
        StringBuffer sql = new StringBuffer();
        sql.append("FROM RecordInfo t where t.username='");
        sql.append(id);
        sql.append("'");
        List<RecordInfo> enterpriseList = super.findObjects(sql.toString(), RecordInfo.class);
        return enterpriseList;
    }


    /**
     * 通过RECORD_ID 查询企业许可证
     *
     * @param record_no
     *
     * @return
     */
    public List<Map> findCertificateByRecordNo(String record_no) {
        StringBuffer sql = new StringBuffer();
        sql.append("select t.certificate_name,t.certificate_order,t.range,t.certificate_no,t.permit_name,to_char(t.valid_period,'yyyy-MM-dd') as valid_period,to_char(t.issue_date,'yyyy-MM-dd') as issue_date, t.issue_branch from CERTIFICATE t where t.record_no='");
        sql.append(record_no);
        sql.append("'");
        List<Map> certificateList = super.findResult(sql.toString(), new HashMap());

        return certificateList;
    }

    /**
     * 查询已收藏的企业信息
     *
     * @param userid
     * @param limit
     * @param offset
     *
     * @return
     */
    public List<Map> findCollectedEnterpriseInfo(String userid, String keywords, int limit, int offset) {
        StringBuffer sql = new StringBuffer();
        sql.append("select W.*,(select count(1) from DRAFT_PERMIT r where  W.username=r.company_user ) as num from (");
        sql.append(" select * from (select t.username,t.record_no,t.com_name,t.user_type,t.reg_address,ROWNUM as RN From RECORD_INFO t where t.username in (");
        sql.append(" select sourceid from collect c where c.type=1 and c.userid ='");
        sql.append(userid);
        sql.append("' )");
        if (!"".equals(keywords) && keywords != null) {
            sql.append(" and t.com_name like '%");
            sql.append(keywords);
            sql.append("%'");
        }
        sql.append(" ) where RN> ");
        sql.append(offset);
        sql.append(" and RN<=");
        sql.append(offset + limit);
        sql.append(") W");

        List<Map> enterpriseList = super.findResult(sql.toString(), new HashMap());

        return enterpriseList;
    }


}
