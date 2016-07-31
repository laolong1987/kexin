package com.web.controller.admin;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.SearchTemplate;
import com.utils.ConvertUtil;
import com.utils.MD5Util;
import com.web.entity.Supervisor;
import com.web.entity.USER_IN;
import com.web.service.SupervisorService;
import com.web.service.UserInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sukey on 2016/7/3.
 */
@Controller
@RequestMapping("/admin/supervisor")
public class SupervisorController {

    @Autowired
    private UserInService userInService;

    @Autowired
    private SupervisorService supervisorService;

    @RequestMapping(value = "add-user", method = RequestMethod.GET)
    public String addSupervisor(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("m5", "ahover");
        return "/jsp/yw/xjjgyh";
    }


    @RequestMapping(value = "add-user", method = RequestMethod.POST)
    public String saveSupervisor(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String company = request.getParameter("company");
        String department = request.getParameter("department");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        if ("".equals(password) || null == password) {
            password = "kxpt111111";
        }
        String tip = "添加失败";
         userInService.findUseInByUserName(username);
        if ("".equals(username) || username == null) {
            tip = "用户名不可为空";
            USER_IN user_in = userInService.findUseInByUserName(username);
        } else if (userInService.findUseInByUserName(username)!=null){//判断用户是否存在
            tip = "该用户已存在";
        }
        else {
            USER_IN user_in = new USER_IN();
            user_in.setUesername(username);
            user_in.setPassword(MD5Util.string2MD5(password));
            user_in.setRole_type("SUPERVISOR");
            user_in.setPw_question("默认密码提示问题");
            user_in.setPw_answer("默认密码提示问题答案");
            user_in.setCreate_time(new Date());
            userInService.saveUserIn(user_in);

            Supervisor supervisor = new Supervisor();
            supervisor.setUesername(username);
            supervisor.setName(name);
            supervisor.setSex(gender);
            supervisor.setGov_name(company);
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
            supervisor.setRecord_time(new Date());
            supervisorService.saveSupervisor(supervisor);
            tip="添加成功";
        }
        request.setAttribute("tip", tip);
//        supervisorService.saveSupervisor(supervisor);
        return "/jsp/yw/xjjgyh";
    }

    @RequestMapping(value = "check-username", method = RequestMethod.POST)
    @ResponseBody
    public String checkUsername(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        USER_IN user_in = userInService.findUseInByUserName(username);
        String res = "true";
        if (user_in != null) {
            res = "false";
        }
        return  res;
    }

    @RequestMapping(value = "/manage", method = RequestMethod.GET)
        public String listWarings(HttpServletRequest request, HttpServletResponse response) {
            int page = ConvertUtil.safeToInteger(request.getParameter("page"), 1);
            int pageSize = 10;
            Map p = new HashMap();
            p.put("page", page);
            p.put("pageSize", pageSize);
            SearchTemplate searchTemplate = supervisorService.findSupervisorManageInfo(p);
            request.setAttribute("list", searchTemplate.getValues());
            int max = searchTemplate.getCount() / pageSize;
            if (searchTemplate.getCount() % 10 != 0) {
                max++;
            }
            int begin = page - 1;
            int end = page + 1;
            if (begin < 1) {
                begin = 1;
                if (end < max) {
                    end++;
                }
            }
            if (end > max) {
                end = max;
                if (begin > 1) {
                    begin--;
                }
            }
            request.setAttribute("max", max);
            request.setAttribute("begin", begin);
            request.setAttribute("end", end);
            request.setAttribute("page", page);
            //设置左边菜单高亮
            request.setAttribute("m5", "ahover");
            return "/jsp/yw/jgyhgl";
        }

}
