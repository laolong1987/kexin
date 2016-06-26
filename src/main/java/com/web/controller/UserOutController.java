package com.web.controller;

import com.web.service.UserOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sukey on 2016/6/25.
 */
@Controller
@RequestMapping("/userout")
public class UserOutController {
    @Autowired
    private UserOutService userOutService;

}
