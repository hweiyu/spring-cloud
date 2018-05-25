package com.hwy.bean;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/23 15:52
 **/
public class BaseMessage {

    /**
     * 全局唯一标识，用于消费者端幂等处理
     */
    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
