package com.std.sms.sent.hhxx;

;

public class Test {

    public static String url = "http://118.145.18.144:5888/sms.aspx";

    public static String userid = "48";

    public static String account = "hh8004";

    public static String password = "hh8004";

    public static void main(String[] args) {
        send();
        // overage();
        // keyword();
        // queryStatus();
        // queryCall();
    }

    public static void send() {
        String mobile = "13958092437";
        String content = "【个金所】尊敬的用户,您的验证码是1111 ,请妥善保留";
        String res = SmsClientSend.sendSms(url, userid, account, password,
            mobile, content);
        if (!res.contains("ok")) {
            System.out.println("错");
        }
        System.out.println(res);
    }

    public static void overage() {
        String res = SmsClientOverage.queryOverage(url, userid, account,
            password);
        System.out.println(res);
    }

    public static void keyword() {
        String checkWord = "屏蔽字";
        String res = SmsClientKeyword.queryKeyWord(url, userid, account,
            password, checkWord);
        System.out.println(res);
    }

    public static void queryStatus() {
        String res = SmsClientQueryStatus.queryStatus(url, userid, account,
            password);
        System.out.println(res);
    }

    public static void queryCall() {
        String res = SmsClientQueryCall.queryCall(url, userid, account,
            password);
        System.out.println(res);
    }
}
