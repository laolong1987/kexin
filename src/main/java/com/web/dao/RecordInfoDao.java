package com.web.dao;


import com.common.BaseDao;
import com.common.SearchTemplate;
import com.web.entity.*;
import com.web.model.ProductCommentModel;
import com.web.model.ReportProductVO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaoyang on 16/2/29.
 */
@Repository
public class RecordInfoDao extends BaseDao {

    /**
     * 查询
     *
     * @param map
     * @return
     */
    public List<Map> searchRECORD_INFO(Map map) {
        StringBuffer sql = new StringBuffer();
        sql.append("select t.com_name,t.user_type,t.address from RECORD_INFO t where 1=1");

        if(map.containsKey("name") && !"".equals(map.get("name"))){
            sql.append(" and t.name like '%").append(map.get("name")).append("%'");
        }
        List<Map> list = super.findResult(sql.toString(),map);
        return list;
    }


    /**
     * 查询产品举报信息
     *
     * @param map
     * @return
     */
    public SearchTemplate searchReportProduct(Map map) {
        StringBuffer sql = new StringBuffer();
        sql.append("select t.id, t.title,t.status,to_char(t.create_time,'yyyy-MM-dd HH24:mm:ss') as create_time ");
        sql.append(",t.product_name,t.company_name ,to_char(t.update_time,'yyyy-MM-dd HH24:mm:ss') as update_time  ");
        sql.append(" from report_product t where 1=1");
        if (map.containsKey("productname") && !"".equals(map.get("productname"))){
            sql.append(" and t.product_name like :productname ");
            map.put("productname", "%" + map.get("productname") + "%");
        }
        if (map.containsKey("status") && !"".equals(map.get("status"))){
            sql.append(" and t.status =:status ");
        }
        if (map.containsKey("userid") && !"".equals(map.get("userid"))){
            sql.append(" and t.user_id =:userid ");
        }
        sql.append(" order by t.create_time desc");
        return  super.search(sql.toString(),map);
    }

    /**
     * 查询企业举报信息
     *
     * @param map
     * @return
     */
    public SearchTemplate searchReportCompany(Map map) {
        StringBuffer sql = new StringBuffer();
        sql.append("select t.address, t.id,t.title,t.status,to_char(t.create_time,'yyyy-MM-dd HH24:mm:ss') as create_time ");
        sql.append(",t.company_name ,to_char(t.update_time,'yyyy-MM-dd HH24:mm:ss') as update_time ");
        sql.append(" from report_company t where 1=1  ");
        if (map.containsKey("companyname") && !"".equals(map.get("companyname"))){
            sql.append(" and t.company_name like :companyname ");
            map.put("companyname", "%" + map.get("companyname") + "%");
        }
        if (map.containsKey("status") && !"".equals(map.get("status"))){
            sql.append(" and t.status =:status ");
        }
        if (map.containsKey("userid") && !"".equals(map.get("userid"))){
            sql.append(" and t.user_id =:userid ");
        }
        sql.append(" order by t.create_time desc");
        return  super.search(sql.toString(),map);
    }

    /**
     * 查询
     *
     * @return
     */
    public List<ReportHandle> findreporthandle(String reportid,int reporttype) {
        StringBuffer sql = new StringBuffer();
        sql.append("select * from report_handle t where 1=1");
        sql.append(" and report_type=:report_type and report_id=:report_id and status=1 ");
        Map map=new HashMap();
        map.put("report_id",reportid);
        map.put("report_type",reporttype);
        List<ReportHandle> list = super.findObjects(sql.toString(),map, ReportHandle.class);
        return list;
    }

    /**
     * 查询
     *
     * @return
     */
    public List<ReportReminder> findReportReminder(String userid) {
        StringBuffer sql = new StringBuffer();
        sql.append("select * from REPORT_REMINDER t where 1=1");
        sql.append(" and user_id=:userid  ");
        Map map=new HashMap();
        map.put("userid",userid);
        List<ReportReminder> list = super.findObjects(sql.toString(),map, ReportReminder.class);
        return list;
    }

        public List<ReportReminder> findReportReminder() {
        StringBuffer sql = new StringBuffer();
        sql.append("select * from REPORT_REMINDER t where 1=1");
        Map map=new HashMap();
        List<ReportReminder> list = super.findObjects(sql.toString(),map, ReportReminder.class);
        return list;
    }

    public List<ProductComment> findProductComment(String productid) {
        StringBuffer sql = new StringBuffer();
        sql.append("select * from product_comment t where 1=1 and productid=:productid");
        Map map=new HashMap();
        map.put("productid",productid);
        List<ProductComment> list = super.findObjects(sql.toString(),map, ProductComment.class);
        return list;
    }

    public List<Map> findProductComment2(String productid) {
        StringBuffer sql = new StringBuffer();
        sql.append("select to_char(t.create_time,'yyyy-MM-dd HH24:mm:ss') as create_time,t.DIRECTIONS,t.ISFALSE,t.POINT ,a.name,t.userid from product_comment t");
        sql.append(" left  join user_out a on t.USERID=a.MOBILE_PHONE where a.role_type='MOBILE_USER' and t.productid=:productid ");
        Map map=new HashMap();
        map.put("productid",productid);
        List<Map> list = super.findResult(sql.toString(),map);
        return list;
    }

    /**
     * 查询
     *
     * @param
     * @return
     */
    public List<Map> searchReportSMS() {
        StringBuffer sql = new StringBuffer();
        sql.append("select t.id,a.day,a.time,a.phone from report_sms t ");
        sql.append(" left join REPORT_REMINDER a on t.USER_ID=a.USER_ID where t.status=0 ");

        List<Map> list = super.findResult(sql.toString(),new HashMap());
        return list;
    }


    /**
     * 查询
     *
     * @return
     */
    public List<ReportProductCode> findReportProductCode(String code) {
        StringBuffer sql = new StringBuffer();
        sql.append("select * from REPORT_PRODUCT_CODE t where ");
        sql.append("  t.code=:code  ");
        Map map=new HashMap();
        map.put("code",code);
        List<ReportProductCode> list = super.findObjects(sql.toString(),map, ReportProductCode.class);
        return list;
    }


    public List<Map> findProduct(Map map) {
        StringBuffer sql = new StringBuffer();
        sql.append("select t.id,t.product_name,t.picurl,t.manufacturer, (select avg(a.point) from product_comment a where t.id=a.productid ) as point from draft_permit t  ");
        sql.append(" where 1=1  ");
        if(map.containsKey("productname") && !"".equals(map.get("productname"))){
            sql.append(" and t.product_name like '%").append(map.get("productname")).append("%'");
        }
        List<Map> list = super.findResult(sql.toString(),map);
        return list;
    }

    public List<Map> findLicense(String companyname) {
        StringBuffer sql = new StringBuffer();
        sql.append("select t.record_no,t.CERTIFICATE_ORDER from CERTIFICATE t left join record_info a on a.RECORD_NO=t.record_no ");
        sql.append(" where a.com_name=:com_name ");
        Map map=new HashMap();
        map.put("com_name",companyname);
        List<Map> list = super.findResult(sql.toString(),map);
        return list;
    }

    public List<Map> findWebSite(String draft_id) {
        StringBuffer sql = new StringBuffer();
        sql.append("select t.WEBSITE_NAME,t.WEBSITE_ADDRESS from sale_website t where t.draft_id=:draft_id ");
        Map map=new HashMap();
        map.put("draft_id",draft_id);
        List<Map> list = super.findResult(sql.toString(),map);
        return list;
    }

    public String getProductCommentpoint(String productid){
        StringBuffer sql=new StringBuffer();
        sql.append("select avg(point) from product_comment where productid=:productid");
        Map map = new HashMap();
        map.put("productid",productid);
         return String.valueOf(super.getUniqueResult(sql.toString(),map));
    }
}
