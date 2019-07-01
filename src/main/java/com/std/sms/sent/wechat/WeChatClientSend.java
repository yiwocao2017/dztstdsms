package com.std.sms.sent.wechat;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.std.sms.bo.ISystemChannelBO;
import com.std.sms.common.JsonUtil;
import com.std.sms.util.HttpsUtil;

/**
 * @author: xieyj 
 * @since: 2016年11月27日 下午2:41:08 
 * @history:
 */
@Component
public class WeChatClientSend {
    protected static final Logger logger = LoggerFactory
        .getLogger(WeChatClientSend.class);

    @Autowired
    private ISystemChannelBO systemChannelBO;

    public boolean sendWeChatSingle(String accessToken, String content) {
        boolean result = false;
        // 请求链接
        String prefixPostUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
        // 发送内容
        WxTemplate wxTemplate = JsonUtil.json2Bean(content, WxTemplate.class);
        // // token获取，并组装
        // if (StringUtils.isBlank(accessToken)) {
        // accessToken = getAccessToken(privateKey1, privateKey2);
        // // systemChannelBO.refreshSystemChannel(id, accessToken);
        // }
        String postUrl = prefixPostUrl + accessToken;
        WeChatSendResult weChatSendResult = sendWxContent(postUrl, wxTemplate);
        if ("0".equals(weChatSendResult.getErrcode())) {
            result = true;
        }
        // else if (EWxErrorCode.EXPIRE.getCode().equals(
        // weChatSendResult.getErrcode())) {
        // // 请求超时，重新获取，保存到数据库中
        // accessToken = getAccessToken(privateKey1, privateKey2);
        // // systemChannelBO.refreshSystemChannel(id, accessToken);
        // postUrl = prefixPostUrl + accessToken;
        // WeChatSendResult weChatResult = sendWxContent(postUrl, wxTemplate);
        // if ("ok".equals(weChatResult.getErrmsg())) {
        // result = true;
        // }
        // }
        return result;
    }

    // 获取模板
    public List<Template> getTemplateList(String accessToken) {
        List<Template> result = null;
        // 发送对接
        String postUrl = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token="
                + accessToken;
        String response = null;
        try {
            response = new String(HttpsUtil.post(postUrl, "", "UTF-8"));
            Gson gson = new Gson();
            if (StringUtils.isNotBlank(response)) {
                // 去除外面大类{}
                response = response.substring(response.indexOf("["),
                    response.lastIndexOf("}"));
            }
            result = gson.fromJson(response, new TypeToken<List<Template>>() {
            }.getType());
        } catch (Exception e) {
            logger.error("error:" + e.getMessage());
        }
        return result;
    }

    public WeChatSendResult sendWxContent(String postUrl, WxTemplate wxTemplate) {
        WeChatSendResult weChatSendResult = null;
        // 发送微信请求
        String response = null;
        try {
            response = new String(HttpsUtil.post(postUrl,
                JsonUtil.Object2Json(wxTemplate), "UTF-8"));
            weChatSendResult = JsonUtil.json2Bean(response,
                WeChatSendResult.class);
            if ("0".equals(weChatSendResult.getErrcode())) {
                logger.info("errcode:" + weChatSendResult.getErrcode()
                        + ";errmsg:" + weChatSendResult.getErrmsg());
            } else {
                logger.error("errcode:" + weChatSendResult.getErrcode()
                        + ";errmsg:" + weChatSendResult.getErrmsg());
            }
        } catch (Exception e) {
            System.out.println(wxTemplate.toString());
            logger.error("error:" + e.getMessage() + "&postUrl:" + postUrl);
        }
        return weChatSendResult;
    }

    public String getAccessToken(String privateKey1, String privateKey2) {
        String accessToken = null;
        String postUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
                + privateKey1 + "&secret=" + privateKey2;
        String response = null;
        try {
            response = new String(HttpsUtil.post(postUrl, "", "UTF-8"));
            TokenResponse tokenResponse = JsonUtil.json2Bean(response,
                TokenResponse.class);
            accessToken = tokenResponse.getAccess_token();
        } catch (Exception e) {
            logger.error("error:" + e.getMessage());
        }
        return accessToken;
    }

    public String getNickname(String accessToken, String weChatId) {
        String nickname = null;
        String postUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="
                + accessToken + "&openid=" + weChatId + "&lang=zh_CN";
        // 发送微信请求
        String response = null;
        try {
            response = new String(HttpsUtil.post(postUrl, "", "UTF-8"));
            UserDetail userDetail = JsonUtil.json2Bean(response,
                UserDetail.class);
            nickname = userDetail.getNickname();
        } catch (Exception e) {
            logger.error("error:" + e.getMessage());
        }
        return nickname;
    }

    public String getOpenIdList(String accessToken) {
        String openIds = null;
        String postUrl = "https://api.weixin.qq.com/cgi-bin/user/get?access_token="
                + accessToken;
        try {
            openIds = new String(HttpsUtil.post(postUrl, "", "UTF-8"));
        } catch (Exception e) {
            logger.error("error:" + e.getMessage());
        }
        return openIds;
    }

    public static void main(String[] args) {
        // String key1 = "wx8bc03dd744895352";
        // String key2 = "44ebf0ef908dc54656573625a579ea82";
        // String token = getAccessToken(key1, key2);
        // System.out.println(token);
        //
        // List<Template> data = getTemplateList(token);
        // System.out.println(data.get(0).getTemplate_id());
        // System.out
        // .println(getNickname(
        // "Pr_PzpVcdlg76Lw8huKbSEuRqeXCj-NHpxnJYakZuY9KwW9iZe3RwALnAAsBGuNAExCyBWkVuDa4HW0yYYR_Xsfs92_cBWHivPmY7R2D1mBh_lDcnyek6lkRnpQT7dwxTDPiAEADNZ",
        // "omRftwR8qrXwfM-9tZbQ4aEu8jYk"));
    }
}
