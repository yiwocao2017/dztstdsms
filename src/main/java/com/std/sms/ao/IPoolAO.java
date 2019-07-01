package com.std.sms.ao;

import java.util.List;

import com.std.sms.domain.Pool;

public interface IPoolAO {

    /** 
     * 将待发短信存放到待发池
     * @param mobile
     * @param content
     * @param channel
     * @param sendDatetime
     * @return 
     * @create: 2016年7月7日 下午8:07:38 zuixian
     * @history: 
     */
    public String doSaveSOutToPool(String channel, String mobile,
            String content, String sendDatetime);

    /** 
     * 从待发池中删除已发短信
     * @param code 
     * @create: 2016年7月7日 下午8:07:41 zuixian
     * @history: 
     */
    public void doRemoveSOutFromPool(String code);

    /** 
     * 查询待发池中的待发短信列表
     * @param code 
     * @create: 2016年7月7日 下午8:37:45 zuixian
     * @history: 
     */
    public List<Pool> queryPoolList(String code);

    /** 
     * 定时从待发池中发送短信
     *  
     * @create: 2016年7月8日 下午4:35:34 zuixian
     * @history: 
     */
    public void doSendFromPool();
}
