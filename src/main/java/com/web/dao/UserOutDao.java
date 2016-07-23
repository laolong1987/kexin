package com.web.dao;

import java.util.List;
import java.util.Map;

import com.common.BaseDao;
import com.common.SearchTemplate;
import com.web.entity.USER_OUT;
import org.springframework.stereotype.Repository;

/**
 * Created by sukey on 2016/6/25.
 * 外部用户Dao
 */
@Repository
public class UserOutDao extends BaseDao {

    public List findUser(USER_OUT user) {
        StringBuffer sql = new StringBuffer();
        sql.append("From USER_OUT u where 1=1");
        if (user.getUsername() != null && !"".equals(user.getUsername())) {
            sql.append(" and u.username =:username");
        }
        if (user.getMobile_phone() != null && !"".equals(user.getContact_phone())) {
            sql.append(" and u.mobile_phone =:mobile_phone");
        }
        if(user.getRole_type() != null && !"".equals(user.getRole_type())){
            sql.append(" and u.role_type =:role_type");
        }

        return super.findObjects(sql.toString(), user);
    }

    /**
        * 后台用户管理查询
        *
        * @param map
        *
        * @return
        */
       public SearchTemplate findUserManageInfo(Map map) {
           StringBuffer sql = new StringBuffer();
           sql.append("select t.mobile_phone,t.name,t.create_time,(select count(*) from COLLECT c where c.userid=t.mobile_phone and c.type=1) as collectEp,(select count(*) from COLLECT c where c.userid=t.mobile_phone and c.type=2) as collectGoods,((select count(*) from Report_Company r where r.user_id=t.mobile_phone ) + (select count(*) from Report_Product rp where rp.user_id=t.mobile_phone )) as reportNum, (select to_char(max(uot.create_time),'yyyy-MM-dd HH24:mm:ss') from USER_OUT_TOKEN uot  where uot.phone=t.mobile_phone ) as login_time from USER_OUT t where t.role_type='MOBILE_USER' ");
           sql.append(" order by t.create_time desc");
           return super.search(sql.toString(), map);
       }
}
