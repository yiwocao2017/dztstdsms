/**
 * @Title BizConnecter.java 
 * @Package com.ibis.pz.http 
 * @Description 
 * @author miyb  
 * @date 2015-5-12 下午9:44:59 
 * @version V1.0   
 */
package com.std.sms.http;

import java.util.Properties;

import com.std.sms.common.PropertiesUtil;
import com.std.sms.core.RegexUtils;
import com.std.sms.exception.BizException;

/** 
 * @author: miyb 
 * @since: 2015-5-12 下午9:44:59 
 * @history:
 */
public class BizConnecter {
    public static final String YES = "0";

    public static final String USER_URL = PropertiesUtil.Config.USER_URL;

    public static final String POST_URL = "...";

    public static <T> T getBizData(String code, String json, Class<T> clazz) {
        String data = getBizData(code, json);
        return JsonUtils.json2Bean(data, clazz);
    }

    public static String getBizData(String code, String json) {
        String data = null;
        String resJson = null;
        try {
            Properties formProperties = new Properties();
            formProperties.put("code", code);
            formProperties.put("json", json);
            resJson = PostSimulater.requestPostForm(getPostUrl(code),
                formProperties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 开始解析响应json
        String errorCode = RegexUtils.find(resJson, "errorCode\":\"(.+?)\"", 1);
        String errorInfo = RegexUtils.find(resJson, "errorInfo\":\"(.+?)\"", 1);
        System.out.println("request:" + code + " with parameters " + json
                + "\nresponse:" + errorCode + "<" + errorInfo + ">.");
        if (YES.equalsIgnoreCase(errorCode)) {
            data = RegexUtils.find(resJson, "data\":(.*)\\}", 1);
        } else {
            throw new BizException("Biz000", errorInfo);
        }
        return data;
    }

    private static String getPostUrl(String code) {
        String postUrl = POST_URL;
        if (code.contains("805")) {
            postUrl = USER_URL;
        } else {
            postUrl = POST_URL;
        }
        return postUrl;
    }
}
