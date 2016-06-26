package com.web.service;

import java.util.List;

import com.web.dao.UserOutDao;
import com.web.entity.USER_OUT;
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
//    public MessageVO checkLogin(USER_OUT user) {
//        MessageVO msg=new MessageVO();
//        List<USER_OUT> ulist=userOutDao.findUser(user);
//        if(ulist.size()==1){
//            USER_OUT u=ulist.get(0);
//            if(u.getPassword().equals(user.getPassword())){
//                msg.setResult(ulist);
//                msg.setMessage("success");
//            }
//            else{
//                msg.setMessage("fail [invalid password]");
//            }
//        }else{
//            msg.setMessage("fail [invalid username]");
//        }
//        msg.setCode(ResultCode.RESULT_CODE_SUCC);
//        return msg;
//    }
}
