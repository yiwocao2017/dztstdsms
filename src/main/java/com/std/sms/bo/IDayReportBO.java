package com.std.sms.bo;

import java.util.List;

import com.std.sms.bo.base.IPaginableBO;
import com.std.sms.domain.DayReport;

public interface IDayReportBO extends IPaginableBO<DayReport> {
    /** 
     * 保存日报表
     * @param data 
     * @create: 2016年7月8日 下午5:45:26 zuixian
     * @history: 
     */
    public int saveDayReport(String companyCode, String channel,
            String sucTimes, String failTimes);

    /** 
     * 查询单条日报表记录
     * @param data 
     * @create: 2016年7月8日 下午5:46:32 zuixian
     * @history: 
     */
    public DayReport getDayReport(DayReport data);

    /** 
     * 查询日报表列表
     * @param data
     * @return 
     * @create: 2016年7月8日 下午5:47:47 zuixian
     * @history: 
     */
    public List<DayReport> queryDayReportList(DayReport data);
}
