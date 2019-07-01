package com.std.sms.dto.req;

public class XN805042Req {
    // 登录名（必填）
    private String loginName;

    // 更新人(必填)
    private String updater;

    // 类别(必填)
    private String kind;

    // 角色编号(选填)
    private String roleCode;

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
