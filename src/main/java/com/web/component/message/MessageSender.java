package com.web.component.message;

/**
 * Created by Michael on 2016/6/28.
 */
public interface MessageSender {

    void batchSend(String message, String mobile, String... otherMobiles);
}
