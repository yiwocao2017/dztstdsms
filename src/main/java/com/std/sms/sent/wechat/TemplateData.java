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
public class TemplateData {
    private String value;

    private String color;

    public TemplateData() {
    }

    public TemplateData(String value) {
        this.value = value;
    }

    public TemplateData(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
