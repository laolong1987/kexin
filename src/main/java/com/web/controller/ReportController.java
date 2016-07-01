package com.web.controller;

import com.utils.ConvertUtil;
import com.web.entity.RecordInfo;
import com.web.entity.ReportCompany;
import com.web.entity.ReportProduct;
import com.web.entity.Uploadfile;
import com.web.model.*;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
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
        for(Uploadfile file:list){
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
    public ReportCompany addReportCompany(ReportCompanyModel reportCompanyModel, HttpServletRequest request, HttpServletResponse response) throws IOException {
        ReportCompany reportCompany=new ReportCompany();
        reportCompany.setUuid(reportCompanyModel.getUuid());
        reportCompany.setStatus(0);
        reportCompany.setCompany_name(reportCompanyModel.getCompany_name());
        reportCompany.setTitle(reportCompanyModel.getTitle());
        reportCompany.setDescription(reportCompanyModel.getDescription());
        reportCompany.setCreate_time(new Date());
        reportCompany.setUpdate_time(new Date());
        recordInfoService.saveReportCompany(reportCompany);

        //根ID查询文件
        List<Uploadfile> list= uploadFileService.findUploadfileByUUID(reportCompanyModel.getUuid());
        for (Uploadfile file:list ) {
            file.setType(1);
            file.setUpdate_time(new Date());
            file.setReport_id(reportCompany.getId());
            file.setReport_type(1);
            uploadFileService.saveUploadFile(file);

            //把文件转移出临时目录
            /**构建保存的目录**/
            String tmpPathDir = "/tmp";
            String filePathDir = "/file";
            String tmpRealPathDir = request.getSession().getServletContext().getRealPath(tmpPathDir);
            String fileRealPathDir = request.getSession().getServletContext().getRealPath(filePathDir);

            /**根据真实路径创建目录**/
            String fileName = tmpRealPathDir + File.separator + file.getFilepath();
            File file1 = new File(fileName);
            File file2 = new File(fileRealPathDir);
            FileUtils.copyFileToDirectory(file1,file2);
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
            reportProduct.setCompany_name(ConvertUtil.safeToString(map.get("company_name"),""));
            reportProduct.setProduct_name(ConvertUtil.safeToString(map.get("product_name"),""));
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


    @RequestMapping(value = "/report-product/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public RepReportProductModel getreportproduct(@PathVariable String id){
        RepReportProductModel reportProductModel=new RepReportProductModel();
        ReportProduct reportProduct = recordInfoService.getReportProduct(id);
        if(null!=reportProduct){
            reportProductModel.setTitle(reportProduct.getTitle());
            reportProductModel.setDescription(reportProduct.getDescription());
            reportProductModel.setCode(reportProduct.getCode());
            reportProductModel.setCompany_name(reportProduct.getCompany_name());
            reportProductModel.setProduct_name(reportProduct.getProduct_name());

            List<String> lists=new ArrayList<>();

            List<Uploadfile> list = uploadFileService.findUploadfileByReportId(reportProduct.getId(),"1");
            for (Uploadfile uploadfile: list ) {
                lists.add(uploadfile.getId());
            }
            reportProductModel.setFileidlist(lists);
        }
        return reportProductModel;
    }


    @RequestMapping(value = "/report-company", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<RepReportCompanyModel> listreportcompany(){
        Map p=new HashMap();
        List<RepReportCompanyModel> reportCompanyModels=new ArrayList<>();
        List<Map> list= recordInfoService.searchReportCompany(p);
        for (Map map:list) {
            RepReportCompanyModel reportProduct = new RepReportCompanyModel();
            reportProduct.setTitle(ConvertUtil.safeToString(map.get("title"),""));
            reportProduct.setCreate_time(ConvertUtil.safeToString(map.get("create_time"),""));
            reportProduct.setCompany_name(ConvertUtil.safeToString(map.get("company_name"),""));
            int status=ConvertUtil.safeToInteger("status",0);
            if(0==status){
                reportProduct.setStatus("处理中");
            }else{
                reportProduct.setStatus("已处理");
            }
            reportCompanyModels.add(reportProduct);
        }
        return reportCompanyModels;
    }

    @RequestMapping(value = "/report-company/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public RepReportCompanyDetailModel getreportcompany(@PathVariable String id){
        RepReportCompanyDetailModel reportCompanyModel=new RepReportCompanyDetailModel();
        ReportCompany reportCompany = recordInfoService.getReportCompany(id);
        if(null!=reportCompany){
            reportCompanyModel.setTitle(reportCompany.getTitle());
            reportCompanyModel.setCompany_name(reportCompany.getCompany_name());
            List<String> lists=new ArrayList<>();
            List<Uploadfile> list = uploadFileService.findUploadfileByReportId(reportCompany.getId(),"2");
            for (Uploadfile uploadfile: list ) {
                lists.add(uploadfile.getId());
            }
            reportCompanyModel.setFileidlist(lists);
        }
        return reportCompanyModel;
    }
}
