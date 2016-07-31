package com.web.dao;

import java.util.List;
import java.util.Map;

import com.common.BaseDao;
import com.common.SearchTemplate;
import com.web.entity.Supervisor;
import com.web.entity.USER_IN;
import org.springframework.stereotype.Repository;

/**
 * Created by sukey on 2016/7/3.
 */
@Repository
public class SupervisorDao extends BaseDao {

    /**
     * 后台监管用户管理查询
     *
     * @param map
     *
     * @return
     */
    public SearchTemplate findSupervisorManageInfo(Map map) {
        StringBuffer sql = new StringBuffer();
        sql.append("select t.uesername,t.name,t.sex,t.gov_name,t.depart_name,t.email,t.contact_phone from SUPERVISOR t where 1=1 ");
        sql.append(" order by t.record_time desc");
        return super.search(sql.toString(), map);
    }

    public List findSupervisor(Supervisor supervisor) {
        StringBuffer sql = new StringBuffer();
        sql.append("From Supervisor u where 1=1");
        if (supervisor.getUesername() != null && !"".equals(supervisor.getUesername())) {
            sql.append(" and u.uesername =:uesername");
        }
        return super.findObjects(sql.toString(), supervisor);
    }
}
