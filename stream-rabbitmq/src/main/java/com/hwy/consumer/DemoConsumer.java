package com.hwy.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/21 17:21
 **/
@EnableBinding(Sink.class)
public class DemoConsumer {

    @StreamListener(Sink.INPUT)
    public void consumer(Object message) {
        System.out.println("===========consumer:" + message);
    }
}
