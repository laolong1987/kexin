package com.web.controller;

import com.utils.ConvertUtil;
import com.web.entity.RecordInfo;
import com.web.entity.ReportCompany;
import com.web.entity.ReportProduct;
import com.web.entity.Uploadfile;
import com.web.model.ErrorModel;
import com.web.model.ReportCompanyModel;
import com.web.model.ReportProductModel;
import com.web.model.ReportProductVO;
import com.web.service.RecordInfoService;
import com.web.service.UploadFileService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.io.File;
import java.util.*;

/**
 * Created by gaoyang on 16/2/28.
 */
@RestController
public class ReportController {

    @Autowired
    RecordInfoService recordInfoService;

    @Autowired
    UploadFileService uploadFileService;

    @RequestMapping(value="/report-products", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public ReportProduct addReportProduct(ReportProductModel reportProductModel){
        ReportProduct reportProduct=new ReportProduct();
        reportProduct.setUuid(reportProductModel.getUuid());
        reportProduct.setStatus(0);
        reportProduct.setCompany_name(reportProductModel.getCompany_name());
        reportProduct.setProduct_name(reportProductModel.getProduct_name());
        reportProduct.setTitle(reportProductModel.getTitle());
        reportProduct.setDescription(reportProductModel.getDescription());
        reportProduct.setCode(reportProductModel.getCode());
        reportProduct.setCreate_time(new Date());
        reportProduct.setUpdate_time(new Date());
        recordInfoService.saveReportProduct(reportProduct);

        //根据UUID查询文件
        List<Uploadfile> list= uploadFileService.findUploadfileByUUID(reportProductModel.getUuid());
        for (Uploadfile file:list ) {
            file.setType(1);
            file.setUpdate_time(new Date());
            file.setReport_id(reportProduct.getId());
            file.setReport_type(2);
            uploadFileService.saveUploadFile(file);
        }
        return reportProduct;
    }

    @RequestMapping(value="/report-company", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    @ResponseStatus(HttpStatus.CREATED)
    public ReportCompany addReportCompany(ReportCompanyModel reportCompanyModel){
        ReportCompany reportCompany=new ReportCompany();
        reportCompany.setUuid(reportCompanyModel.getUuid());
        reportCompany.setStatus(0);
        reportCompany.setCompany_name(reportCompanyModel.getCompany_name());
        reportCompany.setTitle(reportCompanyModel.getTitle());
        reportCompany.setDescription(reportCompanyModel.getDescription());
        reportCompany.setCreate_time(new Date());
        reportCompany.setUpdate_time(new Date());
        recordInfoService.saveReportCompany(reportCompany);

        //根据UUID查询文件
        List<Uploadfile> list= uploadFileService.findUploadfileByUUID(reportCompanyModel.getUuid());
        for (Uploadfile file:list ) {
            file.setType(1);
            file.setUpdate_time(new Date());
            file.setReport_id(reportCompany.getId());
            file.setReport_type(1);
            uploadFileService.saveUploadFile(file);

            //把文件转移出临时目录
//            File
//            FileUtils.copyFileToDirectory();
        }
        return reportCompany;
    }


    @RequestMapping(value = "/report-product", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ReportProductVO> listreportproduct(){
        Map p=new HashMap();
        List<ReportProductVO> reportProductVOList=new ArrayList<>();
        List<Map> list= recordInfoService.searchReportProduct(p);
        for (Map map:list) {
            ReportProductVO reportProduct = new ReportProductVO();
            reportProduct.setTitle(ConvertUtil.safeToString(map.get("title"),""));
            reportProduct.setCreate_time(ConvertUtil.safeToString(map.get("create_time"),""));

            int status=ConvertUtil.safeToInteger("status",0);
            if(0==status){
                reportProduct.setStatus("处理中");
            }else{
                reportProduct.setStatus("已处理");
            }
            reportProductVOList.add(reportProduct);
        }
        return reportProductVOList;
    }


//    @RequestMapping(value = "/report-product/{id}", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public void getreportproduct(@PathVariable String id){
//        RecordInfo recordInfo=recordInfoService.getReportProduct(id);
//        if(null!=recordInfo){
//            return recordInfo;
//        }else{
//            return null;
//        }
//    }



}
