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

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Warings> search(@RequestParam(required = false) String keywords, @RequestParam(required = false) String page, @RequestParam(required = false) String pageSize) {
        int pg = 0;
        int pgS = 0;
        if (page != null && !"".equals(page)) {
            pg = Integer.parseInt(page);
        }
        if (pageSize != null && !"".equals(pageSize)) {
            pgS = Integer.parseInt(pageSize);
        }
        List<Warings> waringsList = waringsInfoService.findWaringsInfoByKeyWords(keywords,pg,pgS);
        return waringsList;
    }

}
