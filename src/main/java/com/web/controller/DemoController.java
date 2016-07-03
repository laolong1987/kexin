package com.web.controller;

import com.utils.StringUtil;
import com.web.entity.Demo;
import com.web.service.DemoService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaoyang on 16/2/28.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    DemoService demoService;

    @RequestMapping(value = "/show")
    public String show(HttpServletRequest request,
                                HttpServletResponse response) {

//        request.setAttribute("list",demoService.searchList(new HashMap()));

        String tmpPathDir = "/tmp";
        String filePathDir = "/file";
        String tmpRealPathDir = request.getSession().getServletContext().getRealPath(tmpPathDir);
        String fileRealPathDir = request.getSession().getServletContext().getRealPath(filePathDir);

        /**根据真实路径创建目录**/
        String fileName = tmpRealPathDir + File.separator + "fj.jpg";
        File file1 = new File(fileName);
        File file2 = new File(fileRealPathDir);
        try {
            FileUtils.copyFileToDirectory(file1,file2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "/jsp/demo";
    }

    @RequestMapping(value = "/add")
    public String add(HttpServletRequest request,
                                         HttpServletResponse response) {

        String id= StringUtil.safeToString(request.getParameter("id"),"");
        String name= StringUtil.safeToString(request.getParameter("name"),"");

        Demo demo=new Demo();
        if(!"".equals(id)){
            demo=demoService.get(Integer.parseInt(id));
        }
        demo.setName(name);
        demoService.save(demo);
        return show(request,response);
    }

    @RequestMapping(value = "/del")
    public void del(HttpServletRequest request,
                      HttpServletResponse response) {

        String id= StringUtil.safeToString(request.getParameter("id"),"");

        if(!"".equals(id)){
            demoService.del(Integer.parseInt(id));
        }

    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody Map<String, String> param) {
        System.out.println(11111111);
        return "success";
    }
}
