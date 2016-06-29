package com.web.service;

import java.util.List;

import com.web.dao.UserOutDao;
import com.web.entity.USER_OUT;
import com.web.model.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sukey on 2016/6/25.
 */

@Service
public class UserOutService {

    @Autowired
    private UserOutDao userOutDao;

    /*
    *
    * 用户登录查询
    * 用户存在返回user对象，否则返回null;
    */
    public USER_OUT findUserOutByUserName(String username) {
        USER_OUT user = new USER_OUT();
        user.setUsername(username);
        List<USER_OUT> ulist = userOutDao.findUser(user);
        USER_OUT u = null;
        if (ulist.size() == 1) {
            u = ulist.get(0);
        }
        return u;
    }

    /**
     * 通过手机号查询用户
     * 用户存在返回user对象，否则返回null;
     */
    public USER_OUT findUserOutByPhone(String phone) {
        USER_OUT user = new USER_OUT();
        user.setMobile_phone(phone);
        List<USER_OUT> ulist = userOutDao.findUser(user);
        USER_OUT u = null;
        if (ulist.size() == 1) {
            u = ulist.get(0);
        }
        return u;
    }

    public void saveUserOut(USER_OUT user) {
        userOutDao.save(user);
    }
}
