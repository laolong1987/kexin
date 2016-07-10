package com.web.controller;

import java.util.List;

import com.web.model.EnterpriseModel;
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

    @RequestMapping(value = "search",method = RequestMethod.GET)
    public List<EnterpriseModel> search(@RequestParam String  keywords){
        List<EnterpriseModel> list=enterpriseService.findEnterpriseInfoByKeyWords(keywords);
        return list;
    }


}
