package com.hwy.provider;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/21 17:34
 **/
public interface SinkSender {

    @Output(Sink.INPUT)
    MessageChannel output();
}
