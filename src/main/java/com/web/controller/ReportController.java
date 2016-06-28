package com.web.controller;

import com.web.entity.RecordInfo;
import com.web.entity.ReportProduct;
import com.web.entity.Uploadfile;
import com.web.model.ErrorModel;
import com.web.model.ReportProductModel;
import com.web.service.RecordInfoService;
import com.web.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        reportProductModel.getUuid();
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

}
