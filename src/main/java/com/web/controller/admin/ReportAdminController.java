package com.web.controller.admin;

import com.utils.ConvertUtil;
import com.utils.StringUtil;
import com.web.entity.Demo;
import com.web.service.DemoService;
import com.web.service.RecordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaoyang on 16/2/28.
 */
@Controller
@RequestMapping("/admin/report")
public class ReportAdminController {

    @Autowired
    RecordInfoService recordInfoService;

    @RequestMapping(value = "/showreportcompany")
    public String showreportcompany(HttpServletRequest request,
                                HttpServletResponse response) {
        String companyname= ConvertUtil.safeToString(request.getParameter("companyname"),"");
        Map p=new HashMap();
        p.put("companyname",companyname);
        request.setAttribute("list",recordInfoService.searchReportCompany(p));

        //设置左边菜单高亮
        request.setAttribute("m3","ahover");
        return "/jsp/yw/qyjbxxcl";
    }

}
