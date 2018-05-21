package com.hwy.provider;

import com.hwy.bean.DemoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/21 17:25
 **/
@Component
@EnableBinding(value = {Source.class})
public class DemoProvider {

    @Autowired
    @Output(Source.OUTPUT)
    private MessageChannel channel;

    public void message(String message) {
        channel.send(MessageBuilder.withPayload(new DemoBean(message)).build());
    }
}
