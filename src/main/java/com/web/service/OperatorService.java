package com.web.service;

import java.util.List;

import com.web.dao.OperatorDao;
import com.web.entity.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sukey on 2016/7/26.
 */
@Service
public class OperatorService {

    @Autowired
    private OperatorDao operatorDao;

    public void saveOperator(Operator operator) {
        operatorDao.save(operator);
    }

    public Operator findOperator(String username) {
        Operator operator = new Operator();
        operator.setUsername(username);
        List<Operator> list = operatorDao.findOperator(operator);

        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
