package com.web.controller;

import com.common.Constant;
import com.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;

/**
 * Created by sukey on 2016/7/6.
 */
@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private RestOperations restOperations;

    @RequestMapping(value = "/geocoding", method = RequestMethod.GET)
    public String geocoding(@RequestParam String lat, @RequestParam String lng) {
        StringBuilder url = new StringBuilder();
        url.append("http://api.map.baidu.com/geocoder/v2/?ak=");
        url.append(Constant.BaiDuApiKey);
        url.append("&callback=renderReverse&location=");
        url.append(lat);
        url.append(",");
        url.append(lng);
        url.append("&output=xml&pois=0");
        String response = restOperations.getForObject(url.toString(), String.class);
        String location= StringUtil.matchStr("<formatted_address>(.*)</formatted_address>",response);
        if(location!=null)
            location=location.substring(location.indexOf(">")+1,location.lastIndexOf("<"));
        else
            location="定位失败";
        return location;
    }
}
