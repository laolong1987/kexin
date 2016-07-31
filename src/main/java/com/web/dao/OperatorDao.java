package com.web.dao;

import java.util.List;

import com.common.BaseDao;
import com.web.entity.Operator;
import com.web.entity.Supervisor;
import org.springframework.stereotype.Repository;

/**
 * Created by sukey on 2016/7/26.
 */
@Repository
public class OperatorDao extends BaseDao {

    public List findOperator(Operator operator) {
        StringBuffer sql = new StringBuffer();
        sql.append("From Operator u where 1=1");
        if (operator.getUsername() != null && !"".equals(operator.getUsername())) {
            sql.append(" and u.username =:username");
        }
        return super.findObjects(sql.toString(), operator);
    }

}
