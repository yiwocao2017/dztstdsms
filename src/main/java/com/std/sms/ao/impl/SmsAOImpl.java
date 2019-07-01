package com.std.sms.ao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.std.sms.ao.ISmsAO;
import com.std.sms.bo.IReceiverBO;
import com.std.sms.bo.ISmsBO;
import com.std.sms.bo.ISystemChannelBO;
import com.std.sms.bo.ISystemTemplateBO;
import com.std.sms.bo.ITemplateBO;
import com.std.sms.bo.base.Paginable;
import com.std.sms.common.JsonUtil;
import com.std.sms.domain.Receiver;
import com.std.sms.domain.Sms;
import com.std.sms.domain.SystemChannel;
import com.std.sms.domain.SystemTemplate;
import com.std.sms.enums.EBoolean;
import com.std.sms.enums.EChannelType;
import com.std.sms.enums.EPushType;
import com.std.sms.enums.ESmsStatus;
import com.std.sms.enums.ESmsType;
import com.std.sms.exception.BizException;
import com.std.sms.sent.jiguang.JPushClientSend;
import com.std.sms.sent.sms.DxClientSend;
import com.std.sms.sent.wechat.TemplateData;
import com.std.sms.sent.wechat.WeChatClientSend;
import com.std.sms.sent.wechat.WxTemplate;

@Service
public class SmsAOImpl implements ISmsAO {

    @Autowired
    private ISmsBO smsBO;

    @Autowired
    private ISystemChannelBO systemChannelBO;

    @Autowired
    private IReceiverBO receiverBO;

    @Autowired
    private ITemplateBO templateBO;

    @Autowired
    private ISystemTemplateBO systemTemplateBO;

    @Autowired
    private WeChatClientSend weChatClientSend;

    @Autowired
    private DxClientSend dxClientSend;

    @Override
    public void toSendDxSms(Sms data) {
        String systemCode = data.getToSystemCode();
        String toKind = data.getToKind();
        String mobile = data.getToMobile();
        String content = data.getSmsContent();
        String status = ESmsStatus.TOSEND.getCode();
        if (ESmsType.NOW_SEND.getCode().equals(data.getSmsType())) {
            Receiver condition = new Receiver();
            condition.setSystemCode(systemCode);
            condition.setLevel(toKind);
            condition.setMobile(mobile);
            List<Receiver> receiverList = receiverBO
                .queryReceiverList(condition);
            if (CollectionUtils.isNotEmpty(receiverList)) {
                for (Receiver receiver : receiverList) {
                    boolean result = sendSms(systemCode, receiver.getMobile(),
                        content, data.getPushType());
                    if (result) {
                        status = ESmsStatus.SENT_YES.getCode();
                    } else {
                        status = ESmsStatus.SENT_NO.getCode();
                    }
                    data.setToMobile(receiver.getMobile());
                    data.setStatus(status);
                    smsBO.saveSms(data);
                }
            } else {
                boolean result = sendSms(systemCode, data.getToMobile(),
                    content, data.getPushType());
                if (result) {
                    status = ESmsStatus.SENT_YES.getCode();
                } else {
                    status = ESmsStatus.SENT_NO.getCode();
                }
                data.setToMobile(data.getToMobile());
                data.setStatus(status);
                smsBO.saveSms(data);
            }
        }
    }

    private boolean sendSms(String systemCode, String mobile, String content,
            String pushType) {
        boolean result = true;
        SystemChannel smsSc = systemChannelBO.getSystemChannelByCondition(
            systemCode, EChannelType.SMS, pushType);
        content = "【" + smsSc.getRemark() + "】" + content;
        if (EPushType.CSMD.getCode().equals(pushType)) {
            result = dxClientSend.sendByCSMD(smsSc.getPrivateKey1(),
                smsSc.getPrivateKey2(), mobile, content);
        } else if (EPushType.HHXX.getCode().equals(pushType)) {
            result = dxClientSend
                .sendByHHXX(smsSc.getPrivateKey1(), smsSc.getPrivateKey2(),
                    smsSc.getPrivateKey3(), mobile, content);
        } else if (EPushType.Z253.getCode().equals(pushType)) {
            result = dxClientSend.sendBy253(smsSc.getPrivateKey1(),
                smsSc.getPrivateKey2(), mobile, content);
        }
        return result;
    }

    @Override
    public void toSendJgSms(Sms data) {
        boolean result = true;
        String mobile = data.getToMobile();
        String systemCode = data.getToSystemCode();
        String content = data.getSmsContent();
        String status = ESmsStatus.TOSEND.getCode();
        if (ESmsType.NOW_SEND.getCode().equals(data.getSmsType())) {
            SystemChannel jgSc = systemChannelBO.getSystemChannelByCondition(
                systemCode, EChannelType.APP, EPushType.JIGUANG.getCode());
            if (StringUtils.isNotBlank(mobile)) {
                Receiver receiver = receiverBO.getReceiver(mobile, systemCode);
                if (StringUtils.isNotBlank(receiver.getJpushId())) {
                    result = JPushClientSend.toSendPush(jgSc.getPrivateKey1(),
                        jgSc.getPrivateKey2(), receiver.getJpushId(), content);
                }
            } else {
                result = JPushClientSend.toSendPush(jgSc.getPrivateKey1(),
                    jgSc.getPrivateKey2(), content);
            }
            if (result) {
                status = ESmsStatus.SENT_YES.getCode();
            } else {
                status = ESmsStatus.SENT_NO.getCode();
            }
            data.setStatus(status);
        }
        smsBO.saveSms(data);
    }

    @Override
    public void toSendWxSms(Sms data) {
        SystemTemplate systemTemplate = systemTemplateBO
            .getSystemTemplateByCondition(data.getToSystemCode(),
                EChannelType.WECHAT.getCode(), EPushType.WEIXIN.getCode(),
                data.getTemplateId());
        String smsContent = null;
        String mobile = data.getToMobile();
        String systemCode = data.getToSystemCode();
        if (StringUtils.isNotBlank(mobile)) {
            smsContent = systemTemplate.getContent();
            for (Map.Entry<String, String> entry : data.getWxSmsContent()
                .entrySet()) {
                String key = entry.getKey();
                smsContent = smsContent.replace("{{" + key + ".DATA}}",
                    entry.getValue());
            }
            data.setSmsContent(smsContent);
            this.sendWeChatSingle(data);
        } else {
            Receiver condition = new Receiver();
            condition.setSystemCode(systemCode);
            condition.setLevel(data.getToKind());
            List<Receiver> receiverList = receiverBO
                .queryReceiverList(condition);
            if (CollectionUtils.isNotEmpty(receiverList)) {
                for (Receiver receiver : receiverList) {
                    smsContent = systemTemplate.getContent();
                    for (Map.Entry<String, String> entry : data
                        .getWxSmsContent().entrySet()) {
                        String key = entry.getKey();
                        if (key.equals("keyword4")) {
                            smsContent = smsContent.replace(
                                "{{keyword4.DATA}}", receiver.getMobile());
                        } else {
                            smsContent = smsContent.replace("{{" + key
                                    + ".DATA}}", entry.getValue());
                        }
                    }
                    data.setSmsContent(smsContent);
                    data.setToMobile(receiver.getMobile());
                    this.sendWeChatSingle(data);
                }
            }
        }
    }

    @Transactional
    private void sendWeChatSingle(Sms data) {
        SystemTemplate systemTemplate = systemTemplateBO
            .getSystemTemplateByCondition(data.getToSystemCode(),
                data.getChannelType(), data.getPushType(), data.getTemplateId());
        String status = ESmsStatus.TOSEND.getCode();
        Receiver receiver = receiverBO.getReceiver(data.getToMobile(),
            data.getToSystemCode());
        String weChatId = receiver.getWechatId();
        if (StringUtils.isNotBlank(weChatId)) {
            WxTemplate content = new WxTemplate(data.getTemplateId(), weChatId,
                systemTemplate.getUrl(), systemTemplate.getKey1(),
                systemTemplate.getKey2(), data.getWxSmsContent());
            Map<String, TemplateData> map = content.getData();
            if (map != null) {
                TemplateData templateData = map.get("keyword4");
                if (null != templateData
                        && StringUtils.isBlank(templateData.getValue())) {
                    templateData.setValue(receiver.getMobile());
                }
            }
            SystemChannel systemChannel = systemChannelBO
                .getSystemChannelByCondition(data.getToSystemCode(),
                    EChannelType.WECHAT, EPushType.WEIXIN.getCode());
            boolean result = weChatClientSend.sendWeChatSingle(
                systemChannel.getPrivateKey3(), JsonUtil.Object2Json(content));
            if (result) {
                status = ESmsStatus.SENT_YES.getCode();
            } else {
                status = ESmsStatus.SENT_NO.getCode();
            }
        } else {
            status = ESmsStatus.SENT_NO.getCode();
        }
        data.setStatus(status);
        smsBO.saveSms(data);
    }

    @Override
    public void addNoticeSms(Sms data) {
        smsBO.saveSms(data);
    }

    @Override
    public void editNoticeSms(Sms data) {
        Sms sms = smsBO.getSms(data.getId());
        if (ESmsStatus.SENT_YES.getCode().equals(sms.getStatus())) {
            throw new BizException("xn702002", "公告已发布，无法修改");
        }
        smsBO.refreshSms(data);
    }

    /** 
     * @see com.std.sms.ao.ISmsAO#toSendNoticeSms(java.lang.Long, java.lang.String)
     */
    @Override
    public void toSendNoticeSms(Long id, String updater) {
        Sms sms = smsBO.getSms(id);
        if (ESmsStatus.SENT_NO.getCode().equals(sms.getStatus())) {
            throw new BizException("xn702002", "公告已下撤，无法发布");
        }
        String status = ESmsStatus.SENT_YES.getCode();
        if (ESmsStatus.SENT_YES.getCode().equals(sms.getStatus())) {
            status = ESmsStatus.SENT_NO.getCode();
        }
        smsBO.refreshSmsStatus(id, status, updater);
    }

    @Override
    public void toSendSms(Sms data) {
        String channelType = data.getChannelType();
        String pushType = data.getPushType();
        if (EBoolean.NO.getCode().equals(channelType)) {
            this.toSendDxSms(data);
            this.toSendJgSms(data);
            this.toSendWxSms(data);
        } else {
            if (ESmsType.NOW_SEND.getCode().equals(data.getSmsType())) {
                if (EPushType.CSMD.getCode().equals(pushType)
                        || EPushType.HHXX.getCode().equals(pushType)) {
                    this.toSendDxSms(data);
                } else if (EPushType.JIGUANG.getCode().equals(pushType)) {
                    this.toSendJgSms(data);
                } else if (EPushType.WEIXIN.getCode().equals(pushType)) {
                    this.toSendWxSms(data);
                } else if (EPushType.NOTICE.getCode().equals(pushType)) {
                    data.setStatus(ESmsStatus.SENT_YES.getCode());
                    this.addNoticeSms(data);
                }
            }
        }
    }

    @Override
    public void reSendSms(Long id) {
        Sms data = smsBO.getSms(id);
        String pushType = data.getPushType();
        if (!ESmsStatus.SENT_NO.getCode().equals(data.getStatus())) {
            throw new BizException("xn702002", "该消息不是失败状态，无法失败重发");
        }
        if (ESmsType.NOW_SEND.getCode().equals(data.getSmsType())) {
            if (EPushType.CSMD.getCode().equals(pushType)
                    || EPushType.HHXX.getCode().equals(pushType)) {
                this.toSendDxSms(data);
            } else if (EPushType.JIGUANG.getCode().equals(pushType)) {
                this.toSendJgSms(data);
            } else if (EPushType.WEIXIN.getCode().equals(pushType)) {
                this.toSendWxSms(data);
            }
        }
    }

    @Override
    public void copySms(Long id) {
        Sms sms = smsBO.getSms(id);
        smsBO.saveSms(sms);
    }

    @Override
    public Paginable<Sms> querySmsPage(int start, int limit, Sms condition) {
        return smsBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<Sms> querySmsList(Sms condition) {
        return smsBO.querySmsList(condition);
    }

    @Override
    public Sms getSms(Long id) {
        return smsBO.getSms(id);
    }

    /** 
     * @see com.std.sms.ao.ISmsAO#doSmsDaily()
     */
    @Override
    public void doSmsDaily() {
    }
}
