package com.web.dao;

import java.util.List;

import com.common.BaseDao;
import com.web.entity.UserOutToken;
import org.springframework.stereotype.Repository;

/**
 * Created by sukey on 2016/6/27.
 */
@Repository
public class UserOutTokenDao extends BaseDao {

    public List findUserToken(UserOutToken userOutToken) {
        StringBuffer sql = new StringBuffer();
        sql.append("From UserOutToken u where 1=1");
        if (userOutToken.getUsername() != null && !"".equals(userOutToken.getUsername())) {
            sql.append(" and u.username =:username");
        }
        if (userOutToken.getToken() != null && !"".equals(userOutToken.getToken())) {
            sql.append(" and u.token =:token");
        }

        return super.findObjects(sql.toString(), userOutToken);
    }
}
