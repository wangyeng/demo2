/*
 * All rights Reserved, Designed By DataDriver
 * Copyright:    DataDriver.Inc
 * Company:      Zhuo Wo Infomation Technology (ShangHai) CO.LTD
 */
package com.datadriver.common.entity;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * UnitedException：通用自定义异常管理
 *
 * @Action 所有应用程序的异常管理全部使用该类，注意log等级
 * @Description loadErrorMessageByCode的方法支持后台异常国际化转化
 */
@SuppressWarnings("serial")
public class UnitedException extends Exception {
    /**
     * 错误代码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 错误参数名
     */
    private String errorParam;

    public UnitedException(Throwable cause) {
        super(cause);
    }

    public UnitedException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

    public UnitedException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }

    public UnitedException(String errorParam, String errorCcode) {
        super(errorCcode);
        this.errorParam = errorParam;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     * @Title: getErrorMessage
     * @Description: 错误代码对应的信息描述
     */
    public String loadErrorMessageByCode(HttpServletRequest request) {
        String errorMessage = "";
        try {
            RequestContext requestContext = new RequestContext(request);// 国际化
            if (StringUtils.isNotBlank(errorParam)) {
                //打印出参数
                errorMessage += "UnitedException ErrorParam [" + errorParam + "] : ";
            }
            errorMessage += requestContext.getMessage(errorCode) + "";
        } catch (Exception e) {
            UnitedLogger.error(e);
            errorMessage = "";
        }
        return errorMessage;
    }

    public String getErrorParam() {
        return errorParam;
    }

}
