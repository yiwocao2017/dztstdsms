package com.std.sms.common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {

    private static Properties props = null;

    public static void init(String configFile) {
        props = new Properties();
        try {
            InputStream in = PropertiesUtil.class
                .getResourceAsStream(configFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            props.load(br);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        if (props == null) {
            // throw new Exception("配置文件初始化失败");
        }
        return props.getProperty(key);
    }

    public static final class Config {
        // 极光环境
        public static String APNS_PRODUCTION = props
            .getProperty("APNS_PRODUCTION");

        // 办件员角色
        public static String BJ_ROLE_CODE = props.getProperty("BJ_ROLE_CODE");

        // 用户链接
        public static String USER_URL = props.getProperty("USER_URL");

        // 验证码有效时间设置
        public static String VALID_MINUTE = props.getProperty("VALID_MINUTE");

        public static String CSMD_URL = props.getProperty("CSMD_URL");

        public static String HHXX_URL = props.getProperty("HHXX_URL");

        public static String SYKJ_URL = props.getProperty("SYKJ_URL");

        public static String Z253_URL = props.getProperty("Z253_URL");

    }
}
