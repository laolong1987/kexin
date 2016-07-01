package com.web.component.message;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

import static org.apache.commons.lang3.StringUtils.join;

/**
 * Created by Michael on 2016/6/28.
 */
@Component
public class MessageSenderImpl implements MessageSender {

    private static final String ENDPOINT = "http://112.124.17.46:7001";

    @Autowired
    private RestOperations restOperations;

    @Override
    public void batchSend(String message, String mobile, String... otherMobiles) {

        String mobiles = mobile;

        if (otherMobiles.length > 0) {
            mobiles += "," + join(otherMobiles, ",");
        }

        String response = restOperations.postForObject(ENDPOINT + "/sms_token", buildForm(message, mobiles), String.class);

        System.out.println(response);
    }

    private MultiValueMap<String, String> buildForm(String message, String mobiles) {
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.set("ddtkey", "zhihuixinyuan");
        form.set("secretkey", DigestUtils.md5Hex("zhihuixinyuan2016"));
        form.set("mobile", mobiles);
        form.set("content", "【可信平台】" + message);
        return form;
    }
}
