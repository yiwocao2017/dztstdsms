package com.std.sms.bo;

import java.util.List;

import com.std.sms.bo.base.IPaginableBO;
import com.std.sms.domain.Pool;

public interface IPoolBO extends IPaginableBO<Pool> {

    /** 
     * 将待发短信放入待发池
     * @param data
     * @return 
     * @create: 2016年7月7日 下午7:54:03 zuixian
     * @history: 
     */
    public String savePool(String channel, String mobile, String content,
            String sendDatetime);

    /** 
     * 将待发短信放入待发池
     * @param data
     * @return 
     * @create: 2016年7月7日 下午7:54:03 zuixian
     * @history: 
     */
    public String savePool(String channel, String mobile, String content,
            String sendDatetime, String companyCode, String systemCode);

    /** 
     * 从待发池中删除已发送的短信
     * @param data
     * @return 
     * @create: 2016年7月7日 下午7:56:23 zuixian
     * @history: 
     */
    public int removePool(String code);

    /** 
     * 查询待发池里的短信
     * @param data
     * @return 
     * @create: 2016年7月7日 下午7:54:18 zuixian
     * @history: 
     */
    public List<Pool> queryPoolList(Pool data);
}
