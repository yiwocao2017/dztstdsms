package com.std.sms.api.impl;

import com.std.sms.ao.IDayReportAO;
import com.std.sms.api.AProcessor;
import com.std.sms.common.DateUtil;
import com.std.sms.common.JsonUtil;
import com.std.sms.domain.DayReport;
import com.std.sms.dto.req.XN799005Req;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;
import com.std.sms.spring.SpringContextHolder;
import com.std.sms.util.DateTimeUtil;

/** 
 * 日报表列表查询
 * @author: zuixian 
 * @since: 2016年7月12日 下午2:58:48 
 * @history:
 */
public class XN799005 extends AProcessor {

    private IDayReportAO dayReportAO = SpringContextHolder
        .getBean(IDayReportAO.class);

    private XN799005Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        DayReport condition = new DayReport();
        condition.setCompanyCode(req.getCompanyCode());
        condition.setChannel(req.getChannel());
        condition.setReportDatetimeStart(DateUtil.getFrontDate(
            req.getReportDateStart(), false));
        condition.setReportDatetimeEnd(DateUtil.getFrontDate(
            req.getReportDateEnd(), true));
        return dayReportAO.queryDayReportList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN799005Req.class);
        if (!DateTimeUtil.isDate(req.getReportDateStart())) {
            throw new ParaException("xn799005", "开始时间格式错误");
        }
        if (!DateTimeUtil.isDate(req.getReportDateEnd())) {
            throw new ParaException("xn799005", "结束时间格式错误");
        }
    }

}
