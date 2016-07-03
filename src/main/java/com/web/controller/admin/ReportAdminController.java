package com.web.controller.admin;

import com.common.SearchTemplate;
import com.utils.ConvertUtil;
import com.utils.StringUtil;
import com.web.entity.Demo;
import com.web.entity.ReportCompany;
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
import java.util.Date;
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

//
//        for(int i=1;i<15;i++){
//            ReportCompany reportCompany=new ReportCompany();
//            reportCompany.setCompany_name("企业名称"+i);
//            reportCompany.setStatus(0);
//            reportCompany.setTitle("举报标题"+i);
//            reportCompany.setCreate_time(new Date());
//            reportCompany.setUpdate_time(new Date());
//            reportCompany.setDescription("举报内容"+i);
//            recordInfoService.saveReportCompany(reportCompany);
//        }


        String companyname= ConvertUtil.safeToString(request.getParameter("companyname"),"");
        int status= ConvertUtil.safeToInteger(request.getParameter("status"),0);
        int page= ConvertUtil.safeToInteger(request.getParameter("page"),1);
        int pageSize= 10;
        Map p=new HashMap();
        p.put("companyname",companyname);
        p.put("status",status);
        p.put("page",page);
        p.put("pageSize",pageSize);
        SearchTemplate searchTemplate=  recordInfoService.findReportCompany(p);
        request.setAttribute("list",searchTemplate.getValues());

        int max=searchTemplate.getCount()/pageSize;
        if (searchTemplate.getCount() % 10 != 0){
            max++;
        }
        int begin=page-1;
        int end=page+1;
        if(begin<1){
            begin=1;
            if(end<max){
                end++;
            }
        }
        if(end>max){
            end=max;
            if(begin>1){
                begin--;
            }
        }



        request.setAttribute("max",max);
        request.setAttribute("begin",begin);
        request.setAttribute("end",end);
        request.setAttribute("page",page);


        //设置左边菜单高亮
        request.setAttribute("m3","ahover");
        request.setAttribute("companyname",companyname);
        return "/jsp/yw/qyjbxxcl";
    }

}
