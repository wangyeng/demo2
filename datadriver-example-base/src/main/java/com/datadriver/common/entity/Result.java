/*
 * All rights Reserved, Designed By DataDriver
 * Copyright:    DataDriver.Inc
 * Company:      Zhuo Wo Infomation Technology (ShangHai) CO.LTD
 */
package com.datadriver.common.entity;


import java.io.Serializable;


/**
 * Result:是一个通用的响应结果序列化对象
 *
 * @Action 所有用于返回一个结果对象，不需要指定结构化的场景
 * @Description Ex01:返回JSON对象<br>Ex02:返回用于判断是否的场景
 */
public class Result implements Serializable {
    private static final long serialVersionUID = 6288374846131788743L;

    /**
     * 信息(一般错误信息才使用)
     */
    private String message;

    /**
     * 信息状态码
     */
    private String messageCode;

    /**
     * 结果状态码
     */
    private String resultCode;

    /**
     * 数据
     */
    private Object data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public Result() {
    }

}
