package com.web.dao;

import java.util.List;
import java.util.Map;

import com.common.BaseDao;
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

        return super.findObjects(sql.toString(), user);
    }
}
