package com.web.service;

import java.util.List;

import com.web.dao.VerifyCodeDao;
import com.web.entity.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sukey on 2016/6/28.
 */

@Service
public class VerifyCodeService {

    @Autowired
    private VerifyCodeDao verifyCodeDao;

    /**
     * 根据电话号码、验证码查询，验证码是否存在
     * @param phone
     * @param code
     * @return
     */
    public VerifyCode findVerifyCode(String phone,String code) {
        VerifyCode verifyCode =new VerifyCode();
        verifyCode.setPhone(phone);
        verifyCode.setCode(code);
        verifyCode.setUsed(1);
        List<VerifyCode> verifyCodeList=verifyCodeDao.findVerifyCode(verifyCode);
        if(verifyCodeList.size()==1){
            return verifyCodeList.get(0);
        }
        return null;
    }

    public void saveVerifyCode(VerifyCode verifyCode){
        verifyCodeDao.save(verifyCode);
    }
}
