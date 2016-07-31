package com.web.controller.admin;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.SearchTemplate;
import com.utils.*;
import com.web.entity.*;
import com.web.model.EnterpriseModel;
import com.web.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sukey on 2016/7/10.
 */
@Controller
@RequestMapping("/admin/warings")
public class WaringController {

    @Autowired
    private WaringsInfoService waringsInfoService;

    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private RecordInfoService recordInfoService;

    @Autowired
    private SupervisorService supervisorService;


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
        String id = request.getParameter("id");
        String publish_date = DateUtil.FormatUIDate(new Date());
        if (id != null && !"".equals(id)) {
            WaringsInfo waringsInfo = waringsInfoService.findWaringsInfoById(id);
            request.setAttribute("waring", waringsInfo);
        }else{
            USER_IN user = (USER_IN) request.getSession().getAttribute("user_in");
            Supervisor supervisor = supervisorService.findSupervisor(user.getUesername());
            WaringsInfo waringsInfo =new WaringsInfo();
            waringsInfo.setPublish_department(supervisor.getGov_name() + supervisor.getDepart_name());
            request.setAttribute("waring", waringsInfo);
        }


        request.setAttribute("publish_date", publish_date);
        //设置左边菜单高亮
        request.setAttribute("m6", "ahover");
        return "/jsp/yw/xjjsxx";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveWaringInfo(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String department = request.getParameter("department");
        String content = request.getParameter("content");
        String enterprise = request.getParameter("enterprise");
        String product = request.getParameter("product");
        WaringsInfo warinsInfo = new WaringsInfo();
        if (id != null && !"".equals(id)) {
            warinsInfo.setId(id);
        }
        warinsInfo.setCreate_time(new Date());
        warinsInfo.setPublish_department(department);
        warinsInfo.setProduct(product);
        warinsInfo.setContent(content);
        warinsInfo.setTitle(title);
        warinsInfo.setEnterprise(enterprise);
        waringsInfoService.saveWaringsInfo(warinsInfo);
        return "redirect:list-warings";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteWaring(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("wid");
        String result = "failure";
        try {
            if (id != null && !"".equals(id)) {
                waringsInfoService.deleteWaringById(id);
                result = "success";
            }
        } catch (Exception e) {
            result = "failure";
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/matchEnterprise", method = RequestMethod.POST)
    @ResponseBody
    public String matchEnterprise(HttpServletRequest request, HttpServletResponse response) {
        String enterprise = request.getParameter("enterprise");
        List<EnterpriseModel> list = enterpriseService.findEnterpriseInfoByKeyWords(enterprise, null, null);
        String res = "false";
        if (list.size() > 0) {
            res = list.get(0).getEid();
        }
        return res;
    }

    @RequestMapping(value = "/matchProduct", method = RequestMethod.POST)
    @ResponseBody
    public String matchProduct(HttpServletRequest request, HttpServletResponse response) {
        String enterprise = request.getParameter("enterprise");
        String product = request.getParameter("product");
        Map<String, String> queryParameter = new HashMap<>();
        queryParameter.put("productname", product);
        queryParameter.put("companyname", enterprise);
        List<Map<String, Object>> list = recordInfoService.searchProduct(queryParameter).getValues();
        String res = "false";
        if (list.size() > 0) {
            res = StringUtil.safeToString(list.get(0).get("ID"), "");
        }
        return res;
    }


}
