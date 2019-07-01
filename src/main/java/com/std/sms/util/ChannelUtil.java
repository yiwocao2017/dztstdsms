package com.std.sms.util;

public class ChannelUtil {
    /** 
     * 验证是否是正确的通道
     * @param channel
     * @return 验证通过返回true 
     * @create: 2016年7月11日 下午2:05:40 zuixian
     * @history: 
     */
    public static boolean isChannel(String channel) {
        int length = channel.split("-").length;
        if (length != 3) {
            return false;
        }
        return true;
    }
}
