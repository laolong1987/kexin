package com.web.service;

import java.util.List;

import com.web.dao.UserOutTokenDao;
import com.web.entity.UserOutToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sukey on 2016/6/27.
 */
@Service
public class UserOutTokenService {

    @Autowired
    private UserOutTokenDao userOutTokenDao;

    public void saveToken(UserOutToken token) {
        userOutTokenDao.save(token);
    }

    public UserOutToken getUserTokenByToken(String token) {
        UserOutToken userOutToken = new UserOutToken();
        userOutToken.setToken(token);
        List<UserOutToken> ulist = userOutTokenDao.findUserToken(userOutToken);
        UserOutToken u = null;
        if (ulist.size() == 1) {
            u = ulist.get(0);
        }
        return u;
    }

}
