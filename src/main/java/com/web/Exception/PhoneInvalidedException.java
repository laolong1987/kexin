package com.web.Exception;

/**
 * Created by sukey on 2016/7/3.
 */
public class PhoneInvalidedException extends RuntimeException {

    public PhoneInvalidedException() {
        super("该用户已存在");
    }
}
