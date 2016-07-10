package com.web.dao;

import java.util.List;
import java.util.Map;

import com.common.BaseDao;
import com.common.SearchTemplate;
import com.web.entity.WaringsInfo;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by sukey on 2016/7/10.
 */
@Repository
public class WaringsInfoDao extends BaseDao {

    /**
     * 通过关键词查询企业信息
     *
     * @param keyword
     *
     * @return
     */
    public List<WaringsInfo> findWaringsInfoByKeyWords(String keyword) {
        StringBuffer sql = new StringBuffer();
        sql.append("from WaringsInfo where 1=1");
        if (keyword != null) {
            sql.append(" and title like '%");
            sql.append(keyword);
            sql.append("%'");
        }
        List<WaringsInfo> list = super.findObjects(sql.toString(), WaringsInfo.class);
        return list;

    }

    /**
     * 查询警示信息
     *
     * @param map
     *
     * @return
     */
    public SearchTemplate searchWaringsInfo(Map map) {
        StringBuffer sql = new StringBuffer();
        sql.append("select t.id,t.title,t.publish_department,to_char(t.create_time,'yyyy-MM-dd HH24:mm:ss') as create_time ");
        sql.append(" from WARINGS_INFO t where 1=1  ");
        sql.append(" order by t.create_time desc");
        return super.search(sql.toString(), map);
    }


}