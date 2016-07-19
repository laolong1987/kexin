package com.web.controller.admin;

import com.common.SearchTemplate;
import com.utils.ConvertUtil;
import com.web.entity.*;
import com.web.service.RecordInfoService;
import com.web.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaoyang on 16/2/28.
 */
@Controller
@RequestMapping("/admin/collect")
public class CollectAdminController {

    @Autowired
    RecordInfoService recordInfoService;

    @RequestMapping(value = "/showcollectcompany")
    public String showcollectcompany(HttpServletRequest request,
                                HttpServletResponse response) {

        int page= ConvertUtil.safeToInteger(request.getParameter("page"),1);
        int pageSize= 10;
        Map p=new HashMap();
        p.put("page",page);
        p.put("pageSize",pageSize);
        SearchTemplate searchTemplate = recordInfoService.searchCollectCompany(p);
        List<Map<String, Object>> list=searchTemplate.getValues();
        for (Map map: list) {
            String usertype=ConvertUtil.safeToString(map.get("USER_TYPE"),"");
            String sourcide=ConvertUtil.safeToString(map.get("IDCARD_NO"),"");
            String type="";
            if("10".equals(usertype)){
                type="生产型企业或机构";
            }else if("20".equals(usertype)){
                type="经营型企业或机构";
            }else if("30".equals(usertype)){
                type="服务型企业或机构";
            }else if("40".equals(usertype)){
                type="企业或机构消费者";
            }else if("60".equals(usertype)){
                type="个人消费者";
            }
            map.put("type",type);
            map.put("ctime",recordInfoService.findCollectnew(sourcide,1));
            map.put("ltime",recordInfoService.findlogtnew(sourcide,1));
        }
        request.setAttribute("list",list);

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
        request.setAttribute("m2","ahover");

        return "/jsp/yw/qysctj";
    }

    @RequestMapping(value = "/showcollectproduct")
    public String showcollectproduct(HttpServletRequest request,
                                     HttpServletResponse response) {

        int page= ConvertUtil.safeToInteger(request.getParameter("page"),1);
        int pageSize= 10;
        Map p=new HashMap();
        p.put("page",page);
        p.put("pageSize",pageSize);
        SearchTemplate searchTemplate = recordInfoService.searchCollectProduct(p);
        List<Map<String, Object>> list=searchTemplate.getValues();
        for (Map map: list) {
            String sourcide=ConvertUtil.safeToString(map.get("ID"),"");
            map.put("ctime",recordInfoService.findCollectnew(sourcide,2));
            map.put("ltime",recordInfoService.findlogtnew(sourcide,2));
        }
        request.setAttribute("list",list);

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

        return "/jsp/yw/spsctj";
    }
}
