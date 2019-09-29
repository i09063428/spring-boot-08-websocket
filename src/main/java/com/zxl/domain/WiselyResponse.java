package com.zxl.domain;

/**
 * @author zxl16
 * @Date 2019/9/27.
 */
public class WiselyResponse {
    public String responseMessage;

    public WiselyResponse() {
    }

    public WiselyResponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
