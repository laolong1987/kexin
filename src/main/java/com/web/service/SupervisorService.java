package com.web.service;

import com.web.dao.SupervisorDao;
import com.web.entity.Supervisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sukey on 2016/7/3.
 */
@Service
public class SupervisorService {

    @Autowired
    private SupervisorDao supervisorDao;

    public void  saveSupervisor(Supervisor supervisor){
        supervisorDao.save(supervisor);
    }
}
