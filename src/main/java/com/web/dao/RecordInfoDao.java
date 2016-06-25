package com.web.dao;


import com.common.BaseDao;
import com.web.entity.Demo;
import com.web.entity.RECORD_INFO;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by gaoyang on 16/2/29.
 */
@Repository
public class RecordInfoDao extends BaseDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 查询
     *
     * @param map
     * @return
     */
    public List<RECORD_INFO> searchRECORD_INFO(Map map) {
        StringBuffer sql = new StringBuffer();
        sql.append(" from RECORD_INFO where 1=1");

        if(map.containsKey("name") && !"".equals(map.get("name"))){
            sql.append(" and name like '%").append(map.get("name")).append("%'");
        }
        List<RECORD_INFO> list = super.findObjects(sql.toString(),map,RECORD_INFO.class);
        return list;
    }
}
