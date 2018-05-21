package com.hwy.provider.impl;

import com.hwy.bean.DemoBean;
import com.hwy.provider.DemoProvider;
import com.hwy.provider.SinkSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/21 17:24
 **/
@Component
@EnableBinding(SinkSender.class)
public class DemoProviderImpl implements DemoProvider {

    @Autowired
    private SinkSender sinkSender;

    @Override
    public void provider(String message) {
        sinkSender.output().send(MessageBuilder.withPayload(new DemoBean(message)).build());
    }

}
