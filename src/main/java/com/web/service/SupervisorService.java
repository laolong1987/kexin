package com.web.service;

import java.util.List;
import java.util.Map;

import com.common.SearchTemplate;
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

    /**
       * 后台用户管理查询
       *
       * @param map
       *
       * @return
       */
      public SearchTemplate findSupervisorManageInfo(Map map) {
          return supervisorDao.findSupervisorManageInfo(map);
      }

    /**
     * 通过username查询Supervisor
     * @param username
     * @return
     */
    public Supervisor findSupervisor(String username) {
        Supervisor supervisor=new Supervisor();
        supervisor.setUesername(username);
        List<Supervisor> list=supervisorDao.findSupervisor(supervisor);

        if(list.size()>0){
            return  list.get(0);
        }else{
            return null;
        }
    }


}
