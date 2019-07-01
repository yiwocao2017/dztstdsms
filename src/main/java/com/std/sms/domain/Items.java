package com.std.sms.domain;

import com.std.sms.dao.base.ABaseDO;

/**
* 办件
* @author: xieyj 
* @since: 2016年11月29日 19:28:46
* @history:
*/
public class Items extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 问候语
    private String first;

    // 真实姓名
    private String realName;

    // 审批部门
    private String department;

    // 办理事项
    private String content;

    // 联系电话
    private String telephone;

    // 备注
    private String remark;

    // 用户编号
    private String userId;

    // 系统编号
    private String systemCode;

    // ****************db properties ****************
    private String loginName;

    private String updater;

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }

    public String getSystemCode() {
        return systemCode;
    }

}
