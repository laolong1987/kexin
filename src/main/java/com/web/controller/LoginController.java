package com.web.controller;

import java.util.Date;

import com.common.Constant;
import com.utils.*;
import com.web.Exception.*;
import com.web.component.message.MessageSenderImpl;
import com.web.entity.*;
import com.web.model.*;
import com.web.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sukey on 2016/6/25.
 */
@RestController
@RequestMapping("/userout")
public class LoginController {

    @Autowired
    private UserOutService userOutService;

    @Autowired
    private UserOutTokenService userOutTokenService;

    @Autowired
    private VerifyCodeService verifyCodeService;

    @Autowired
    private MessageSenderImpl messageSender;


    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public LoginModel login(@RequestParam String phone, @RequestParam String password) {
        LoginModel model = new LoginModel();
        USER_OUT user = userOutService.findUserOutByPhone(phone);
        if (user == null) {//用户不存在
            throw new UserOutNotFindException();
        }

        if (!user.getPassword().equals(password)) {//密码错误
            throw new PasswordErrorException();
        }
        model.setUserid(user.getMobile_phone());
        model.setUsername(user.getUsername());
        String onceStr = StringUtil.getRandomString(8);
        String token = MD5Util.mmd5(user.getUsername() + onceStr);
        model.setToken(token);

        UserOutToken userOutToken = new UserOutToken();
        userOutToken.setToken(token);
        userOutToken.setCreate_time(new Date());
        userOutToken.setPhone(phone);
        userOutToken.setOncestr(onceStr);
        //保存token对象
        userOutTokenService.saveToken(userOutToken);

        return model;

    }


    @RequestMapping(value = "/get-user-by-username/{username}/{key}", method = RequestMethod.GET)
    public UserOut getUserByUsername(@PathVariable(value = "username") String username, @PathVariable(value = "key") String key) {
        String id_key = username + Constant.key;
        String secret = MD5Util.mmd5(id_key);
        if (!secret.equals(key)) {
            throw new UnAuthorizedException();
        }

        USER_OUT u = userOutService.findUserOutByUserName(username);
        if (u == null) {//用户不存在
            throw new UserOutNotFindException();
        }
        UserOut user = new UserOut();
        user.setUsername(u.getUsername());
        user.setSex(u.getSex());
        user.setAddress(u.getAddress());
        user.setEmail(u.getEmail());
        user.setName(u.getName());

        return user;

    }

    @RequestMapping(value = "/get-user-by-phone/{phone}/{key}", method = RequestMethod.GET)
    public UserOut getUserByPhone(@PathVariable(value = "phone") String phone, @PathVariable(value = "key") String key) {
        String id_key = phone + Constant.key;
        String secret = MD5Util.mmd5(id_key);
        if (!secret.equals(key)) {
            throw new UnAuthorizedException();
        }

        USER_OUT u = userOutService.findUserOutByPhone(phone);
        if (u == null) {//用户不存在
            throw new UserOutNotFindException();
        }
        UserOut user = new UserOut();
        user.setUsername(u.getUsername());
        user.setPhone(phone);
        user.setSex(u.getSex());
        user.setAddress(u.getAddress());
        user.setEmail(u.getEmail());
        user.setName(u.getName());

        return user;

    }

    @RequestMapping(value = "/get-validate-code/{phone}/{key}", method = RequestMethod.GET)
    public String getValidateCode(@PathVariable(value = "phone") String phone, @PathVariable(value = "key") String key) {
        String id_key = phone + Constant.key;
        String secret = MD5Util.mmd5(id_key);
        if (!secret.equals(key)) {
            throw new UnAuthorizedException();
        }

        //生成6位随机数
        String code = StringUtil.getRandomString(6, 0);
        VerifyCode verifyCode = new VerifyCode();
        verifyCode.setCode(code);
        verifyCode.setPhone(phone);
        verifyCode.setCreate_time(new Date());
        verifyCodeService.saveVerifyCode(verifyCode);
        String message = "尊敬的用户您好，您正在进行注册验证，验证码" + code + "，请在15分钟内按页面提示提交验证码，切勿将验证码泄露于他人。";
//        messageSender.batchSend(message, phone);
        return "success";

    }

    @RequestMapping(value = "/checkout-code/{phone}/{code}", method = RequestMethod.GET)
    public LoginModel CheckoutValidateCode(@PathVariable(value = "phone") String phone, @PathVariable(value = "code") String code) {
        VerifyCode verifyCode = verifyCodeService.findVerifyCode(phone, code);
        if (verifyCode == null) {
            throw new VerifyCodeException();
        }

        LoginModel model = new LoginModel();
        model.setUserid(phone);
        String onceStr = StringUtil.getRandomString(8);
        String token = MD5Util.mmd5(phone + onceStr);
        model.setToken(token);

        UserOutToken userOutToken = new UserOutToken();
        userOutToken.setPhone(phone);
        userOutToken.setToken(token);
        userOutToken.setCreate_time(new Date());
        userOutToken.setOncestr(onceStr);
        //保存token对象
        userOutTokenService.saveToken(userOutToken);

        return model;

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public LoginModel register(@RequestParam String username, @RequestParam String password, @RequestParam String token) {

        UserOutToken uot = userOutTokenService.getUserTokenByToken(token);
        if (uot == null) {
            throw new UnAuthorizedException();
        }
        String phone = uot.getPhone();

        USER_OUT user = new USER_OUT();
        user.setMobile_phone(phone);
        user.setUsername(username);
        user.setPassword(password);
        userOutService.saveUserOut(user);

        LoginModel model = new LoginModel();

        model.setUserid(user.getMobile_phone());
        String onceStr = StringUtil.getRandomString(8);
        String token2 = MD5Util.mmd5(user.getMobile_phone() + onceStr + user.getPassword());
        model.setToken(token2);

        UserOutToken userOutToken = new UserOutToken();
        userOutToken.setToken(token2);
        userOutToken.setCreate_time(new Date());
        userOutToken.setPhone(phone);
        userOutToken.setOncestr(onceStr);
        //保存token对象
        userOutTokenService.saveToken(userOutToken);

        return model;

    }

    @RequestMapping(value = "/modify-password", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String modifyPassword(@RequestParam String password, @RequestParam String token) {
        UserOutToken uot = userOutTokenService.getUserTokenByToken(token);
        if (uot == null) {
            throw new UnAuthorizedException();
        }
        USER_OUT user = userOutService.findUserOutByPhone(uot.getPhone());
        user.setPassword(password);
        userOutService.saveUserOut(user);

        return "success";

    }

    @RequestMapping(value = "/modify-username", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String setUsername(@RequestParam String username,  @RequestParam String token) {
        UserOutToken uot = userOutTokenService.getUserTokenByToken(token);
        if (uot == null) {
            throw new UnAuthorizedException();
        }
        String phone = uot.getPhone();
        USER_OUT user = userOutService.findUserOutByPhone(phone);
        user.setUsername(username);
        userOutService.saveUserOut(user);

       return "success";

    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorModel handleUserNotFindException(UserOutNotFindException e) {
        ErrorModel model = new ErrorModelBuilder("000400").addChildError("000402").build();
        return model;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorModel handlePasswordErrorException(PasswordErrorException e) {
        ErrorModel model = new ErrorModelBuilder("000400").addChildError("000401").build();
        return model;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorModel handleUnAuthorizedException(UnAuthorizedException e) {
        ErrorModel model = new ErrorModelBuilder("000300").addChildError("000301").build();
        return model;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorModel handleVerifyCodeException(VerifyCodeException e) {
        ErrorModel model = new ErrorModelBuilder("000300").addChildError("000301").build();
        return model;
    }


}
