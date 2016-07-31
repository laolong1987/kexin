package com.web.controller.admin;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.SearchTemplate;
import com.utils.ConvertUtil;
import com.utils.MD5Util;
import com.web.entity.*;
import com.web.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sukey on 2016/7/19.
 */
@Controller
@RequestMapping("/admin/user")
public class UserManageController {

    @Autowired
    private UserOutService userOutService;

    @Autowired
    private SupervisorService supervisorService;

    @Autowired
    private OperatorService operatorService;

    @Autowired
    private UserInService userInService;

    @RequestMapping(value = "/manage", method = RequestMethod.GET)
    public String listWarings(HttpServletRequest request, HttpServletResponse response) {
        int page = ConvertUtil.safeToInteger(request.getParameter("page"), 1);
        int pageSize = 10;
        Map p = new HashMap();
        p.put("page", page);
        p.put("pageSize", pageSize);
        SearchTemplate searchTemplate = userOutService.findUserManageInfo(p);
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
        request.setAttribute("m1", "ahover");
        return "/jsp/yw/usersmanage";
    }

    @RequestMapping(value = "/personal", method = RequestMethod.GET)
    public String personal(HttpServletRequest request, HttpServletResponse response) {
        USER_IN user = (USER_IN) request.getSession().getAttribute("user_in");
        String role_type = user.getRole_type();
        if (role_type.equals("SUPERVISOR")) {
            Supervisor supervisor = supervisorService.findSupervisor(user.getUesername());
            request.setAttribute("personal", supervisor);
            request.setAttribute("role_type", 2);
            request.setAttribute("m7", "ahover");
        } else {
            Operator operator = operatorService.findOperator(user.getUesername());
            request.setAttribute("personal", operator);
            request.setAttribute("role_type", 1);
            request.setAttribute("m4", "ahover");
        }

        return "/jsp/yw/grxxgl";
    }

    @RequestMapping(value = "/modify-personal", method = RequestMethod.POST)
    public String modifyPersonal(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String company = request.getParameter("company");
        String department = request.getParameter("department");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String original = request.getParameter("original");
        String new_pwd = request.getParameter("new_pwd");
        String confirm_pwd = request.getParameter("confirm_pwd");
        USER_IN user = (USER_IN) request.getSession().getAttribute("user_in");
        String role_type = user.getRole_type();
        Supervisor supervisor = new Supervisor();
        ;
        Operator operator = new Operator();

        if (name != null && !"".equals(name)) {
            supervisor.setName(name);
            operator.setName(name);
        }
        if (gender != null && !"".equals(gender)) {
            supervisor.setSex(gender);
        }
        if (company != null && !"".equals(company)) {
            supervisor.setGov_name(company);
        }
        if (department != null && !"".equals(department)) {
            supervisor.setDepart_name(department);
        }
        if (email != null && !"".equals(email)) {
            supervisor.setEmail(email);
            operator.setEmail(email);
        }
        if (phone != null && !"".equals(phone)) {
            supervisor.setContact_phone(phone);
            operator.setMobile_phone(phone);
        }
        if (role_type.equals("SUPERVISOR")) {
            Supervisor supervisor1 = supervisorService.findSupervisor(user.getUesername());
            if (supervisor1 != null) {
                supervisor.setUesername(supervisor1.getUesername());
                supervisorService.saveSupervisor(supervisor);
                request.setAttribute("personal", supervisor);
                request.setAttribute("role_type", 2);
                request.setAttribute("m7", "ahover");
            }

        }
        if (role_type.equals("SUPERADMIN")) {
            Operator operator1 = operatorService.findOperator(user.getUesername());
            if (operator1 != null) {
                operator.setUsername(operator1.getUsername());
                operatorService.saveOperator(operator);
                request.setAttribute("personal", operator);
                request.setAttribute("role_type", 1);
                request.setAttribute("m4", "ahover");
            }
        }

        if (new_pwd != null && !"".equals(new_pwd)) {
            if (!new_pwd.equals(confirm_pwd)) {
                request.setAttribute("tip", "两次密码输入不一致");
            } else if (!user.getPassword().equals((MD5Util.string2MD5(original)))) {
                request.setAttribute("tip", "原密码输入错误");
            } else {
                user.setPassword(MD5Util.string2MD5(original));
                userInService.saveUserIn(user);
            }
        }
        request.setAttribute("tip", "原密码输入错误");
        return "/jsp/yw/grxxgl";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        request.getSession().removeAttribute("user_in");
        return "/jsp/yw/login";
    }
}
