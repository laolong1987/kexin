package com.web.Exception;

/**
 * Created by sukey on 2016/6/26.
 */
public class UserOutNotFindException extends  RuntimeException {

    public UserOutNotFindException() {
        super("用户不存在");
    }
}
