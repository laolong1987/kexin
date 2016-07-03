package com.web.service;

import java.util.List;

import com.web.dao.UserInDao;
import com.web.dao.UserOutDao;
import com.web.entity.USER_IN;
import com.web.entity.USER_OUT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sukey on 2016/6/25.
 */

@Service
public class UserInService {

    @Autowired
    private UserInDao userInDao;

    /*
    *
    * 用户登录查询
    * 用户存在返回user对象，否则返回null;
    */
    public USER_IN findUseInByUserName(String username) {
        USER_IN user = new USER_IN();
        user.setUesername(username);
        List<USER_IN> ulist = userInDao.findUser(user);
        USER_IN u = null;
        if (ulist.size() == 1) {
            u = ulist.get(0);
        }
        return u;
    }


    public void saveUserIn(USER_IN user) {
        userInDao.save(user);
    }
}
