package com.web.controller.admin;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.SearchTemplate;
import com.utils.ConvertUtil;
import com.web.service.UserOutService;
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
         request.setAttribute("m6", "ahover");
         return "/jsp/yw/jsxxgl";
     }
}
