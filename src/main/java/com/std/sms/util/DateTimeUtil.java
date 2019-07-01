package com.std.sms.util;

public class DateTimeUtil {
    /** 
     * 判断是否是dateTime格式
     * @param channel
     * @param dateTime
     * @return 格式正确返回true
     * @create: 2016年7月11日 下午9:16:00 zuixian
     * @history: 
     */
    public static boolean isDateTime(String channel, String dateTime) {
        boolean result = true;
        if (channel.split("-")[2].equalsIgnoreCase("D")) {
            if (dateTime.matches("\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{2}:\\d{2}")) {
                result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    /** 
     * 判断是否是date格式
     * @param date
     * @return 格式正确返回true
     * @create: 2016年7月11日 下午9:16:40 zuixian
     * @history: 
     */
    public static boolean isDate(String date) {
        return date.matches("\\d{4}-\\d{1,2}-\\d{1,2}");
    }
}
