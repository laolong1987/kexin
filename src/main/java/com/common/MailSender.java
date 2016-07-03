package com.common;

/**
 * Created by Michael on 2016/7/2.
 */
public interface MailSender {

    void batchSend(String subject, String message, boolean html, String email, String... otherEmails);

    void batchSendAsync(String subject, String message, boolean html, String email, String... otherEmails);
}
