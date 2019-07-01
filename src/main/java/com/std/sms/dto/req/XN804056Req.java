package com.std.sms.dto.req;

public class XN804056Req {
    // 用户编号(选填)
    private String userId;

    // 真实姓名(选填)
    private String realName;

    // 审批部门(选填)
    private String department;

    // 系统编号(选填)
    private String systemCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSystemCode() {
        return systemCode;
    }

    public void setSystemCode(String systemCode) {
        this.systemCode = systemCode;
    }
}
