package com.xnjr.sms.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;

public class JPushUtil {
    protected static final Logger LOG = LoggerFactory
        .getLogger(JPushUtil.class);

    private static final String appKey = "e614d2a82d038160f707f1a8";

    private static final String masterSecret = "22d4796873b7f002537f30b6";

    public static void toSendPush(String noticeInfo) {
        ClientConfig clientConfig = ClientConfig.getInstance();
        JPushClient jpushClient = new JPushClient(masterSecret, appKey, null,
            clientConfig);
        // For push, all you need do is to build PushPayload object.
        PushPayload payload = buildPushObject_all_all_alert(noticeInfo);
        try {
            PushResult result = jpushClient.sendPush(payload);
            System.out.println("responseCode:" + result.getResponseCode());
            LOG.info("Got result - " + result);

        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);

        } catch (APIRequestException e) {
            LOG.error(
                "Error response from JPush server. Should review and fix it. ",
                e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
        }
    }

    public static PushPayload buildPushObject_all_all_alert(String alert) {
        return PushPayload.alertAll(alert);
    }

    public static void main(String[] args) {
        toSendPush("123");
    }
}
