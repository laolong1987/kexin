package com.web.controller;

import com.web.model.LoginModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sukey on 2016/6/25.
 */
@RestController
@RequestMapping("/userout")
public class LoginController {

    @RequestMapping(value="/login",method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public LoginModel login (String username, String password){
        return null;

    }


}
