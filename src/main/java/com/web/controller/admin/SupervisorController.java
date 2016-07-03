package com.web.controller.admin;

import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.entity.Supervisor;
import com.web.entity.USER_IN;
import com.web.service.SupervisorService;
import com.web.service.UserInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sukey on 2016/7/3.
 */
@Controller
@RequestMapping("/supervisor")
public class SupervisorController {

    @Autowired
    private UserInService userInService;

    @Autowired
    private SupervisorService supervisorService;

    @RequestMapping(value = "add-user", method = RequestMethod.GET)
    public String addSupervisor() {
        return "/jsp/yw/xjjgyh";
    }


    @RequestMapping(value = "add-user", method = RequestMethod.POST)
    public String saveSupervisor(HttpServletRequest request,HttpServletResponse response) {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String name=request.getParameter("name");
        String gender=request.getParameter("gender");
        String company=request.getParameter("company");
        String department=request.getParameter("department");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");

        String tip="添加成功";
        USER_IN user_in=new USER_IN();
        user_in.setUesername(username);
        user_in.setPassword(password);
        user_in.setRole_type("SUPERVISOR");
        user_in.setPw_question("默认密码提示问题");
        user_in.setPw_answer("默认密码提示问题答案");
        user_in.setCreate_time(new Date());
        userInService.saveUserIn(user_in);

        Supervisor supervisor=new Supervisor();
        supervisor.setUesername(username);
        supervisor.setName(name);
        supervisor.setSex(gender);
        supervisor.setDepart_name(company);
        supervisor.setDepart_name(department);
        supervisor.setContact_phone(phone);
        supervisor.setEmail(email);
        supervisor.setPosition("Empty String");
        supervisor.setProvince("全国");
        supervisor.setCity("Empty String");
        supervisor.setCounty("Empty String");
        supervisor.setAddress("Empty String");
        supervisor.setPostcode("Empty String");
        supervisor.setVerify_status("未审核");
        supervisor.setInspect_status("Empty String");
        supervisorService.saveSupervisor(supervisor);

            request.setAttribute("tip",tip);
//        supervisorService.saveSupervisor(supervisor);
        return "/jsp/yw/xjjgyh";
    }

}
