package com.hwy.bean;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/21 17:26
 **/
public class DemoBean {

    private String message;

    public DemoBean() {}

    public DemoBean(String message) {
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
        return "DemoBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
