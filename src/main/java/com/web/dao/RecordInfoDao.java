package com.web.dao;


import com.common.BaseDao;
import com.common.SearchTemplate;
import com.utils.ConvertUtil;
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
     * 查询产品
     *
     * @param map
     * @return
     */
    public SearchTemplate searchProduct(Map map) {
        StringBuffer sql = new StringBuffer();
        sql.append("select * from(select t.id,t.GENERIC_NAME,t.SERVICE_SECTOR,(select count(a.id) from product_comment a where a.PRODUCTID=t.id) as csize, ");
        sql.append(" (select count(a.id) from product_comment a where a.PRODUCTID=t.id and a.ISFALSE=1) as fsize, ");
        sql.append(" floor((select avg(a.POINT) from product_comment a where a.PRODUCTID=t.id)) as fs ");
        sql.append(" from draft_permit t ) where 1=1 ");
        if (map.containsKey("productname") && !"".equals(map.get("productname"))){
            sql.append(" and GENERIC_NAME like :productname ");
            map.put("productname", "%" + map.get("productname") + "%");
        }
        if (map.containsKey("companyname") && !"".equals(map.get("companyname"))){
            sql.append(" and SERVICE_SECTOR like :companyname ");
            map.put("companyname", "%" + map.get("companyname") + "%");
        }
        if (map.containsKey("beginpoint") && !"".equals(map.get("beginpoint"))){
            sql.append(" and fs >=:beginpoint ");
        }
        if (map.containsKey("endpoint") && !"".equals(map.get("endpoint"))){
            sql.append(" and fs <=:endpoint ");
        }
        if (map.containsKey("beginfalse") && !"".equals(map.get("beginfalse"))){
            sql.append(" and fsize >=:beginfalse ");
        }
        if (map.containsKey("endfalse") && !"".equals(map.get("endfalse"))){
            sql.append(" and fsize <=:endfalse ");
        }
        return  super.search(sql.toString(),map);
    }


    /**
     * 查询产品
     * @return
     */
    public List<Map> searchProduct3(String id) {
        StringBuffer sql = new StringBuffer();
        sql.append("select t.id,t.GENERIC_NAME,t.SERVICE_SECTOR,(select count(a.id) from product_comment a where a.PRODUCTID=t.id) as csize, ");
        sql.append(" (select count(a.id) from product_comment a where a.PRODUCTID=t.id and a.ISFALSE=1) as fsize, ");
        sql.append(" floor((select avg(a.POINT) from product_comment a where a.PRODUCTID=t.id)) as fs ");
        sql.append(" from draft_permit t where t.id=:id");
        Map map=new HashMap();
        map.put("id",id);
        List<Map> list = super.findResult(sql.toString(),map);
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
        sql.append("select t.id,t.GENERIC_NAME,t.picurl,t.manufacturer, (select avg(a.point) from product_comment a where t.id=a.productid ) as point from draft_permit t  ");
        sql.append(" where 1=1  ");
        if(map.containsKey("productname") && !"".equals(map.get("productname"))){
            sql.append(" and t.product_name like '%").append(map.get("productname")).append("%'");
        }
        List<Map> list = super.findResult(sql.toString(),map);
        return list;
    }

    public List<Map> findProductCollect(Map map) {
        StringBuffer sql = new StringBuffer();
        sql.append("select t.id,t.GENERIC_NAME,t.picurl,t.manufacturer, (select avg(a.point) from product_comment a where t.id=a.productid ) as point  from COLLECT b left join draft_permit t on b.SOURCEID=t.id ");
        sql.append(" where 1=1 and userid=:userid  and b.type=2  ");
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

    public String findCollect(String sourceid,int type,String userid){
        StringBuffer sql=new StringBuffer();
        sql.append("select count(id) from collect where type=:type and sourceid=:sourceid and userid=:userid");
        Map map=new HashMap();
        map.put("userid",userid);
        map.put("sourceid",sourceid);
        map.put("type",type);
        String result=String.valueOf(super.getUniqueResult(sql.toString(),map));
        if("0".equals(result)){
            return "0";
        }else{
            return "1";
        }
    }


    /**
     * 查询企业收藏
     *
     * @param map
     * @return
     */
    public SearchTemplate searchCollectCompany(Map map) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select t.IDCARD_NO, t.com_name,t.USER_TYPE,(select count(a.id) from collect a where a.type=1 and a.SOURCEID=t.IDCARD_NO ) as csize, ");
        sql.append("(select count(b.id) from LOGOINFO b where b.type=1 and b.SOURCEID=t.IDCARD_NO ) as lsize ");
        sql.append(" from record_info t  where 1=1  ");
        return  super.search(sql.toString(),map);
    }

    public String findCollectnew(String sourceid,int type) {
        String result="";
        StringBuffer sql = new StringBuffer();
        sql.append("select * from (select to_char(c.create_time,'yyyy-MM-dd HH24:mm:ss') as CREATE_TIME from collect c where c.sourceid=:sourceid and c.type=:type order by c.CREATE_TIME desc) where ROWNUM < 2");
        Map map=new HashMap();
        map.put("sourceid",sourceid);
        map.put("type",type);
        List<Map> list = super.findResult(sql.toString(),map);
        if(list.size()>0){
            result= ConvertUtil.safeToString(list.get(0).get("CREATE_TIME"),"");
        }
        return result;
    }

    public String findlogtnew(String sourceid,int type) {
        String result="";
        StringBuffer sql = new StringBuffer();
        sql.append("select * from (select to_char(c.create_time,'yyyy-MM-dd HH24:mm:ss') as CREATE_TIME from LOGOINFO c where c.sourceid=:sourceid and c.type=:type order by c.CREATE_TIME desc) where ROWNUM < 2");
        Map map=new HashMap();
        map.put("sourceid",sourceid);
        map.put("type",type);
        List<Map> list = super.findResult(sql.toString(),map);
        if(list.size()>0){
            result= ConvertUtil.safeToString(list.get(0).get("CREATE_TIME"),"");
        }
        return result;
    }


    /**
     * 查询商品收藏
     *
     * @param map
     * @return
     */
    public SearchTemplate searchCollectProduct(Map map) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select t.id,t.GENERIC_NAME,t.SERVICE_SECTOR,(select count(a.id) from collect a where a.type=2 and a.SOURCEID=t.id ) as csize, ");
        sql.append(" (select count(b.id) from LOGOINFO b where b.type=2 and b.SOURCEID=t.id ) as lsize ");
        sql.append(" from draft_permit t  ");
        return  super.search(sql.toString(),map);
    }


    public SearchTemplate searchProductComment(Map map) {
        StringBuffer sql = new StringBuffer();
        sql.append("select to_char(t.create_time,'yyyy-MM-dd HH24:mm:ss') as create_time,t.DIRECTIONS,t.ISFALSE,t.POINT ,a.name,t.userid from product_comment t");
        sql.append(" left  join user_out a on t.USERID=a.MOBILE_PHONE where a.role_type='MOBILE_USER' and t.productid=:productid ");
        return  super.search(sql.toString(),map);
    }
}
