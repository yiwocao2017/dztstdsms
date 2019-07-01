package com.std.sms.dto.req;

/**
 * 公告发布/下撤
 * @author: xieyj 
 * @since: 2016年11月29日 上午11:53:27 
 * @history:
 */
public class XN804036Req {
    // 序号(必填)
    private String id;

    // 更新人(必填)
    private String updater;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
}
