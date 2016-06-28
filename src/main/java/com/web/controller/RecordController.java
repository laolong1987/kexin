package com.web.controller;

import com.web.entity.RecordInfo;
import com.web.service.RecordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gaoyang on 16/2/28.
 */
//@RestController
public class RecordController {
//
//    @Autowired
//    RecordInfoService recordInfoService;
//
//    @RequestMapping(value = "/manufacturers", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public List<Map> listmanufacturers(@RequestParam(required = false, defaultValue = "") String name){
//        Map map=new HashMap();
//        map.put("name",name);
//        return recordInfoService.searchRECORD_INFO(map);
//    }
//
//    @RequestMapping(value = "/manufacturers/{id}", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public RecordInfo getlistrecordinfo(@PathVariable String id){
//        RecordInfo recordInfo=recordInfoService.getRecordInfoById(Integer.parseInt(id));
//        if(null!=recordInfo){
//            return recordInfo;
//        }else{
////            throw Exception
//            return null;
//        }
//    }

//    @RequestMapping(value = "/show")
//    public String show(HttpServletRequest request,
//                                HttpServletResponse response) {
//
//        request.setAttribute("list",demoService.searchList(new HashMap()));
//
//        return "/jsp/demo";
//    }

//    @RequestMapping(value = "/add")
//    public String add(HttpServletRequest request,
//                                         HttpServletResponse response) {
//
//        String id= StringUtil.safeToString(request.getParameter("id"),"");
//        String name= StringUtil.safeToString(request.getParameter("name"),"");
//
//        Demo demo=new Demo();
//        if(!"".equals(id)){
//            demo=demoService.get(Integer.parseInt(id));
//        }
//        demo.setName(name);
//        demoService.save(demo);
//        return show(request,response);
//    }
//
//    @RequestMapping(value = "/del")
//    public void del(HttpServletRequest request,
//                      HttpServletResponse response) {
//
//        String id= StringUtil.safeToString(request.getParameter("id"),"");
//
//        if(!"".equals(id)){
//            demoService.del(Integer.parseInt(id));
//        }
//
//    }
//
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    @ResponseBody
//    public String save(@RequestBody Map<String, String> param) {
//        System.out.println(11111111);
//        return "success";
//    }
}
