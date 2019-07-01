package com.std.sms.domain;

import java.util.Date;

import com.std.sms.dao.base.ABaseDO;

/** 
 * @author: zuixian 
 * @since: 2016年7月6日 下午8:30:33 
 * @history:
 */
public class DayReport extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 612663667784971001L;

    // ********* 查询字段 ***********
    Date reportDatetimeStart;

    Date reportDatetimeEnd;

    // 编号
    private String code;

    // 公司编号
    private String companyCode;

    // 短信服务商
    private String channel;

    // 发送成功的条数
    private String sucTimes;

    // 发送失败的条数
    private String failTimes;

    // 日期
    private Date reportDate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getSucTimes() {
        return sucTimes;
    }

    public void setSucTimes(String sucTimes) {
        this.sucTimes = sucTimes;
    }

    public String getFailTimes() {
        return failTimes;
    }

    public void setFailTimes(String failTimes) {
        this.failTimes = failTimes;
    }

    public Date getReportDatetimeStart() {
        return reportDatetimeStart;
    }

    public void setReportDatetimeStart(Date reportDatetimeStart) {
        this.reportDatetimeStart = reportDatetimeStart;
    }

    public Date getReportDatetimeEnd() {
        return reportDatetimeEnd;
    }

    public void setReportDatetimeEnd(Date reportDatetimeEnd) {
        this.reportDatetimeEnd = reportDatetimeEnd;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

}
