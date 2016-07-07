package com.web.controller;

import com.utils.ConvertUtil;
import com.web.entity.ReportCompany;
import com.web.entity.ReportProduct;
import com.web.entity.ReportProductCode;
import com.web.entity.Uploadfile;
import com.web.model.*;
import com.web.service.RecordInfoService;
import com.web.service.UploadFileService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

//import javax.validation.Valid;

/**
 * Created by gaoyang on 16/2/28.
 */
@RestController
public class ProductController {

    @Autowired
    RecordInfoService recordInfoService;


    @RequestMapping(value = "/search-product", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<RepProductModel> listproduct(@RequestParam(required=false ) String productname,@RequestParam(required=false ) String page,@RequestParam(required=false ) String pageSize){
        List<RepProductModel> result=new ArrayList<>();
        Map p=new HashMap();
        p.put("productname",ConvertUtil.safeToString(productname,""));
        p.put("page",page);
        p.put("pageSize",pageSize);
        List<Map> list=recordInfoService.findProduct(p);
        for (Map map:list) {
            RepProductModel product=new RepProductModel();
            product.setCompanyname(ConvertUtil.safeToString(map.get("PRODUCT_NAME"),""));
            product.setProductname(ConvertUtil.safeToString(map.get("MANUFACTURER"),""));
            product.setId(ConvertUtil.safeToString(map.get("ID"),""));
            product.setEvaluation("4");
            product.setPicurl(ConvertUtil.safeToString(map.get("PICURL"),""));
            result.add(product);
        }
        return result;
    }


    @RequestMapping(value = "/search-product/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public RepReportProductModel getproduct(@PathVariable String id){
        RepReportProductModel reportProductModel=new RepReportProductModel();
        ReportProduct reportProduct = recordInfoService.getReportProduct(id);
        if(null!=reportProduct){
            reportProductModel.setTitle(reportProduct.getTitle());
            reportProductModel.setDescription(reportProduct.getDescription());
            reportProductModel.setCode(reportProduct.getCode());
            reportProductModel.setCompany_name(reportProduct.getCompany_name());
            reportProductModel.setProduct_name(reportProduct.getProduct_name());
            reportProductModel.setId(reportProduct.getId());
            List<FileModel> lists=new ArrayList<>();

            reportProductModel.setFileidlist(lists);
        }
        return reportProductModel;
    }



}
