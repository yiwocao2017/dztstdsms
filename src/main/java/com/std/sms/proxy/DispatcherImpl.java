package com.std.sms.proxy;

import com.std.sms.api.IProcessor;
import com.std.sms.common.JsonUtil;
import com.std.sms.common.ReflectUtil;
import com.std.sms.enums.EErrorCode;
import com.std.sms.exception.BizException;
import com.std.sms.exception.ParaException;

public class DispatcherImpl implements IDispatcher {

    @Override
    public String doDispatcher(String transcode, String inputParams) {
        String result = null;
        ReturnMessage rm = new ReturnMessage();
        try {
            // 加载配置文件,proxy实例化
            String classname = "com.std.sms.api.impl.XNOther";
            // ConfigDescribe configDescribe = ConfigLoader.loadConfig();
            // if (StringUtils.isNotBlank(transcode) && configDescribe != null)
            // {
            // List<String> codeList = configDescribe.getCodeList();
            // if (codeList.contains(transcode)) {
            // classname = "com.std.sms.api.impl.XN" + transcode;
            // }
            // }
            classname = "com.std.sms.api.impl.XN" + transcode;

            IProcessor processor = (IProcessor) ReflectUtil
                .getInstance(classname);
            // 接口调用
            Object data = processor.doProcessor(inputParams);
            rm.setErrorCode(EErrorCode.SUCCESS.getCode());
            rm.setErrorInfo(EErrorCode.SUCCESS.getValue());
            if (data == null) {
                rm.setData("");
            } else {
                rm.setData(data);
            }
        } catch (Exception e) {
            if (e instanceof BizException) {
                rm.setErrorCode(EErrorCode.BIZ_ERR.getCode());
                rm.setErrorInfo(((BizException) e).getErrorMessage());
                rm.setData("");
            } else if (e instanceof ParaException) {
                rm.setErrorCode(EErrorCode.PARA_ERR.getCode());
                rm.setErrorInfo(((ParaException) e).getErrorMessage());
                rm.setData("");
            } else {
                rm.setErrorCode(EErrorCode.OTHER_ERR.getCode());
                rm.setErrorInfo(e.getMessage());
                rm.setData("");
            }
        } finally {
            result = JsonUtil.Object2Json(rm);
        }
        return result;
    }
}
