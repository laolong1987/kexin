package com.web.controller;

import com.utils.ConvertUtil;
import com.web.entity.Collect;
import com.web.entity.DraftPermit;
import com.web.entity.ProductComment;
import com.web.model.*;
import com.web.service.EnterpriseService;
import com.web.service.RecordInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//import javax.validation.Valid;

/**
 * Created by gaoyang on 16/2/28.
 */
@RestController
public class CollectController {

    @Autowired
    RecordInfoService recordInfoService;


    @Autowired
    private EnterpriseService enterpriseService;

    private static String IMGURL="http://www.ecdata.org.cn/srv/viewDownloadAction.action?fileName=publishedFile/";


    @RequestMapping(value = "/search-collect-product", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<RepProductModel> searchcollectproduct(@RequestParam(required=false ) String productname,@RequestParam(required=false ) String userid,@RequestParam(required=false ) String page,@RequestParam(required=false ) String pageSize){
        List<RepProductModel> result=new ArrayList<>();
        Map p=new HashMap();
        p.put("productname",ConvertUtil.safeToString(productname,""));
        p.put("page",page);
        p.put("pageSize",pageSize);
        p.put("userid",userid);
        List<Map> list=recordInfoService.findProductCollect(p);
        for (Map map:list) {
            RepProductModel product=new RepProductModel();
            product.setProductname(ConvertUtil.safeToString(map.get("GENERIC_NAME"),""));
            product.setCompanyname(ConvertUtil.safeToString(map.get("MANUFACTURER"),""));
            product.setId(ConvertUtil.safeToString(map.get("ID"),""));
            product.setEvaluation(ConvertUtil.safeToString(map.get("POINT"),""));
            String picurl= ConvertUtil.safeToString(map.get("PICURL"),"");
            if(!"".equals(picurl)){
                String ps[]=picurl.split(";");
                product.setPicurl(IMGURL+ps[0]);
            }
            result.add(product);
        }
        return result;
    }

    

    @RequestMapping(value="/collect-product", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Collect addcollectproduct(@RequestParam(required=false ) String productid, @RequestParam(required=false ) String userid) {
        Collect collect=new Collect();
        collect.setUserid(userid);
        collect.setCreate_time(new Date());
        collect.setUpdate_time(new Date());
        collect.setSourceid(productid);
        collect.setType(2);
        recordInfoService.saveCollect(collect);
        return collect;
    }


    @RequestMapping(value = "/collect-product", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void  delcollectproduct(@RequestParam(required=false ) String productid, @RequestParam(required=false ) String userid){
        recordInfoService.removeCollect(userid,productid,2);
    }

    @RequestMapping(value="/collect-company", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Collect addcollectcompany(@RequestParam(required=false ) String companyid, @RequestParam(required=false ) String userid) {
        Collect collect=new Collect();
        collect.setUserid(userid);
        collect.setCreate_time(new Date());
        collect.setUpdate_time(new Date());
        collect.setSourceid(companyid);
        collect.setType(1);
        recordInfoService.saveCollect(collect);
        return collect;
    }


    @RequestMapping(value = "/collect-company", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void  delcollectcompany(@RequestParam(required=false ) String companyid, @RequestParam(required=false ) String userid){
        recordInfoService.removeCollect(userid,companyid,1);
    }
}
