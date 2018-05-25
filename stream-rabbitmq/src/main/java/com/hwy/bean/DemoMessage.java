package com.hwy.bean;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/21 17:26
 **/
public class DemoMessage extends BaseMessage {

    private String message;

    public DemoMessage() {}

    public DemoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DemoMessage{" +
                "message='" + message + '\'' + "," +
                "version='" + super.getVersion() + '\'' +
                '}';
    }
}
