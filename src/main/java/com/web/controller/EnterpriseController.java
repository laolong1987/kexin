package com.web.controller;

import java.util.List;
import java.util.Map;

import com.web.model.*;
import com.web.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sukey on 2016/7/8.
 */
@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public List<EnterpriseModel> search(@RequestParam String keywords) {
        List<EnterpriseModel> list = enterpriseService.findEnterpriseInfoByKeyWords(keywords);
        return list;
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public EnterpriseDetailModel detail(@RequestParam String id,@RequestParam String record_no) {
        EnterpriseDetailModel model = enterpriseService.findEnterpriseInfoByID(id);
        List<CertificateModel> certificateList=enterpriseService.findCertificateByRecordNo(record_no);
        model.setCertificateModels(certificateList);
        return model;
    }


}
