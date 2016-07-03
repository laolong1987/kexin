package com.web.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utils.MD5Util;
import com.web.entity.USER_IN;
import com.web.service.UserInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sukey on 2016/7/3.
 */
@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    @Autowired
    private UserInService userInService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/jsp/yw/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username != null && !"".equals(username) && password != null && !"".equals(password)) {
            String pwd = MD5Util.string2MD5(password);
            USER_IN user_in = userInService.findUseInByUserName(username);
            if (user_in == null) {
                request.setAttribute("tip", "该用户不存在");

            } else if (!pwd.equals(user_in.getPassword())) {
                request.setAttribute("tip", "密码错误,请重试");
            } else {
                request.getSession().setAttribute("user_in", user_in);
                return "redirect:/admin/report/showreportcompany";
            }
        } else {
            request.setAttribute("tip", "用户名密码不可为空");
        }

        return "/jsp/yw/login";
    }
}
