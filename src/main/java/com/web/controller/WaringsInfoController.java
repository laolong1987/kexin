package com.web.controller;

import java.util.List;

import com.web.model.Warings;
import com.web.service.WaringsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sukey on 2016/7/10.
 */
@RestController
@RequestMapping("/warings")
public class WaringsInfoController {

    @Autowired
    private WaringsInfoService waringsInfoService;

    @RequestMapping("/search")
    public List<Warings> search(@RequestParam String keywords){
        List<Warings> waringsList= waringsInfoService.findWaringsInfoByKeyWords(keywords);
        return waringsList;
    }

}
