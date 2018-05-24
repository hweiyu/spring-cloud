package com.hwy.consumer;

import org.springframework.messaging.Message;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/24 10:25
 **/
public interface Consumer<T> {

    void consumer(Message<T> message);
}
