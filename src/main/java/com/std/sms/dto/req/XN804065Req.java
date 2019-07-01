package com.std.sms.dto.req;

/**
 * @author: xieyj 
 * @since: 2016年12月8日 上午11:08:22 
 * @history:
 */
public class XN804065Req {
    // 系统编号(必填)
    private String systemCode;

    // 渠道大类(0 全渠道 1短信 2 APP 3 微信 4 公告)(必填)
    private String channelType;

    // 渠道小类(11 创世漫道 12 汇禾 21 极光推送 31 微信 41 公告)(必填)
    private String pushType;

    // 模板编号(必填)
    private String templateId;

    // 标题(必填)
    private String title;

    // URL(选填)
    private String url;

    // 字体样式1(选填)
    private String key1;

    // 字体样式2(选填)
    private String key2;

    // 字体样式3(选填)
    private String key3;

    // 内容模板(必填)
    private String content;

    // 备注(选填)
    private String remark;

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    public String getKey3() {
        return key3;
    }

    public void setKey3(String key3) {
        this.key3 = key3;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
