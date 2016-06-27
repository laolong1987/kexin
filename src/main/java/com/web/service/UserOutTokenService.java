package com.web.service;

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

    public void saveToken(UserOutToken token){
        userOutTokenDao.save(token);
    }

}
