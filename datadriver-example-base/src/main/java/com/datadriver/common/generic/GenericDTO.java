/*
 * All rights Reserved, Designed By DataDriver
 * Copyright:    DataDriver.Inc
 * Company:      Zhuo Wo Infomation Technology (ShangHai) CO.LTD
 */
package com.datadriver.common.generic;

/**
 * GenericDTO: 顶级通用DTO
 *
 * @Action 封装通用的分页参数
 * @Description 用于前端与后端Controller参数封装接收，一般不用于返回
 */
public class GenericDTO {
    private int pageNum = 1;
    private int pageSize = 10;
    private boolean needCount = false;
    private String orderString;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isNeedCount() {
        return needCount;
    }

    public void setNeedCount(boolean needCount) {
        this.needCount = needCount;
    }

    public String getOrderString() {
        return orderString;
    }

    public void setOrderString(String orderString) {
        this.orderString = orderString;
    }

}
