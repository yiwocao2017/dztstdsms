/**
 * @Title TemplateData.java 
 * @Package com.std.sms.sent.wechat 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年11月25日 上午10:52:35 
 * @version V1.0   
 */
package com.std.sms.sent.wechat;

/** 
 * @author: haiqingzheng 
 * @since: 2016年11月25日 上午10:52:35 
 * @history:
 */
public class UserData {
    private String openid;

    private String lang;

    public UserData() {
    };

    public UserData(String openid, String lang) {
        this.openid = openid;
        this.lang = lang;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
