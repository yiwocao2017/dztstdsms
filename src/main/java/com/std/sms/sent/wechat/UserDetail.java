package com.std.sms.sent.wechat;

public class UserDetail {
    // 用户是否订阅该公众号标识
    private String subscribe;

    // 用户的标识，对当前公众号唯一
    private String openid;

    // 用户的昵称
    private String nickname;

    // 用户的性别
    private String sex;

    // 用户的语言，简体中文为zh_CN
    private String language;

    // 用户所在城市
    private String city;

    // 用户所在省份
    private String province;

    // 用户所在国家
    private String country;

    // 头像
    private String headimgurl;

    // 关注时间戳
    private String subscribe_time;

    // 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
    private String unionid;

    // 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
    private String remark;

    // 用户所在的分组ID（兼容旧的用户分组接口）
    private String groupid;

    // 用户被打上的标签ID列表
    private String[] tagid_list;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getSubscribe_time() {
        return subscribe_time;
    }

    public void setSubscribe_time(String subscribe_time) {
        this.subscribe_time = subscribe_time;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String[] getTagid_list() {
        return tagid_list;
    }

    public void setTagid_list(String[] tagid_list) {
        this.tagid_list = tagid_list;
    }
}
