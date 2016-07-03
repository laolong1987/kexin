package com.web.dao;

import java.util.List;

import com.common.BaseDao;
import com.web.entity.USER_IN;
import org.springframework.stereotype.Repository;

/**
 * Created by sukey on 2016/6/25.
 * 外部用户Dao
 */
@Repository
public class UserInDao extends BaseDao {

   public List findUser(USER_IN user) {
        StringBuffer sql = new StringBuffer();
        sql.append("From USER_IN u where 1=1");
        if (user.getUesername() != null && !"".equals(user.getUesername())) {
            sql.append(" and u.uesername =:uesername");
        }


        return super.findObjects(sql.toString(), user);
    }
}
