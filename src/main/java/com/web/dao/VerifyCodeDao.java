package com.web.dao;

import java.util.List;

import com.common.BaseDao;
import com.web.entity.VerifyCode;
import org.springframework.stereotype.Repository;

/**
 * Created by sukey on 2016/6/28.
 */
@Repository
public class VerifyCodeDao extends BaseDao {

    public List findVerifyCode(VerifyCode verifyCode) {
        StringBuffer sql = new StringBuffer();
        sql.append("From VerifyCode v where 1=1");
        if (verifyCode.getPhone() != null && !"".equals(verifyCode.getPhone())) {
            sql.append(" and v.phone =:phone");
        }
        if (verifyCode.getCode() != null && !"".equals(verifyCode.getCode())) {
            sql.append(" and v.code =:code");
        }

        if (verifyCode.getUsed() != 0) {
            sql.append(" and v.used =:used");
        }

        return super.findObjects(sql.toString(), verifyCode);
    }
}
