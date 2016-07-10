package com.web.controller.admin;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.SearchTemplate;
import com.utils.ConvertUtil;
import com.web.entity.WaringsInfo;
import com.web.service.WaringsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sukey on 2016/7/10.
 */
@Controller
@RequestMapping("/admin/warings")
public class WaringController {

    @Autowired
    private WaringsInfoService waringsInfoService;

    @RequestMapping(value = "/list-warings", method = RequestMethod.GET)
    public String listWarings(HttpServletRequest request, HttpServletResponse response) {
        int page = ConvertUtil.safeToInteger(request.getParameter("page"), 1);
        int pageSize = 10;
        Map p = new HashMap();
        p.put("page", page);
        p.put("pageSize", pageSize);
        SearchTemplate searchTemplate = waringsInfoService.searchWaringsInfo(p);
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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showAddWaringInfo(HttpServletRequest request, HttpServletResponse response) {
        return "";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveWaringInfo(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        String department = request.getParameter("department");
        String content = request.getParameter("content");
        String enterprise = request.getParameter("enterprise");
        String product = request.getParameter("product");
        WaringsInfo warinsInfo = new WaringsInfo();
        warinsInfo.setCreate_time(new Date());
        warinsInfo.setPublish_department(department);
        warinsInfo.setProduct(product);
        warinsInfo.setContent(content);
        warinsInfo.setTitle(title);
        warinsInfo.setEnterprise(enterprise);
        waringsInfoService.saveWaringsInfo(warinsInfo);
        return "";
    }


}
