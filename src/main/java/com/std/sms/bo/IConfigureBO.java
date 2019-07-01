package com.std.sms.bo;

import java.util.List;

import com.std.sms.bo.base.IPaginableBO;
import com.std.sms.domain.Configure;

public interface IConfigureBO extends IPaginableBO<Configure> {

    /**
     * 查询单条公司配置信息
     * @param companyCode
     * @param channel
     * @param key
     * @return 
     * @create: 2017年2月13日 下午12:46:07 xieyj
     * @history:
     */
    public Configure doGetConfigure(String companyCode, String channel,
            String key);

    /**
     * 获取多条配置
     * @param condition
     * @return 
     * @create: 2017年2月13日 上午11:36:31 xieyj
     * @history:
     */
    public List<Configure> queryConfigureList(Configure condition);

    /**
     * 根据系统编号获取发送渠道类型
     * @param condition
     * @return 
     * @create: 2017年2月13日 上午11:36:31 xieyj
     * @history:
     */
    public String getConfigureChannel(String systemCode);
}
