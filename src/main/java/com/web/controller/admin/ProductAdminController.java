package com.web.controller.admin;

import com.common.SearchTemplate;
import com.utils.ConvertUtil;
import com.web.service.RecordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaoyang on 16/2/28.
 */
@Controller
@RequestMapping("/admin/product")
public class ProductAdminController {

    @Autowired
    RecordInfoService recordInfoService;

    @RequestMapping(value = "/showproduct")
    public String showproduct(HttpServletRequest request,
                                HttpServletResponse response) {

        String productname=ConvertUtil.safeToString(request.getParameter("productname"),"");
        String companyname=ConvertUtil.safeToString(request.getParameter("companyname"),"");
        String beginpoint=ConvertUtil.safeToString(request.getParameter("beginpoint"),"");
        String endpoint=ConvertUtil.safeToString(request.getParameter("endpoint"),"");
        String beginfalse=ConvertUtil.safeToString(request.getParameter("beginfalse"),"");
        String endfalse=ConvertUtil.safeToString(request.getParameter("endfalse"),"");

        int page= ConvertUtil.safeToInteger(request.getParameter("page"),1);
        int pageSize= 10;
        Map p=new HashMap();
        p.put("page",page);
        p.put("pageSize",pageSize);
        p.put("productname",productname);
        p.put("companyname",companyname);
        p.put("beginpoint",beginpoint);
        p.put("endpoint",endpoint);
        p.put("beginfalse",beginfalse);
        p.put("endfalse",endfalse);
        SearchTemplate searchTemplate = recordInfoService.searchProduct(p);
        List<Map<String, Object>> list=searchTemplate.getValues();
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
        request.setAttribute("m1","ahover");

        request.setAttribute("productname",productname);
        request.setAttribute("companyname",companyname);
        request.setAttribute("beginpoint",beginpoint);
        request.setAttribute("endpoint",endpoint);
        request.setAttribute("beginfalse",beginfalse);
        request.setAttribute("endfalse",endfalse);

        return "/jsp/yw/spzlyj";
    }

    @RequestMapping(value = "/showproductdetail")
    public String showproductdetail(HttpServletRequest request,
                              HttpServletResponse response) {

        int page= ConvertUtil.safeToInteger(request.getParameter("page"),1);
        String productid= ConvertUtil.safeToString(request.getParameter("id"),"");
        int pageSize= 10;
        Map p=new HashMap();
        p.put("page",page);
        p.put("pageSize",pageSize);
        p.put("productid",productid);

        List<Map> plist=recordInfoService.searchProduct3(productid);

        if(plist.size()>0){
            request.setAttribute("product",plist.get(0));
        }

        SearchTemplate searchTemplate = recordInfoService.searchProductComment(p);
        List<Map<String, Object>> list=searchTemplate.getValues();
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
        request.setAttribute("m1","ahover");
        request.setAttribute("productid",productid);
        return "/jsp/yw/ckpl";
    }

}
