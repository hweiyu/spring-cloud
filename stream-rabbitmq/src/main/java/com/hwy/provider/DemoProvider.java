package com.hwy.provider;

import com.hwy.bean.DemoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/21 17:25
 **/
@EnableBinding(value = {DemoSource.class})
public class DemoProvider {

    @Autowired
    private DemoSource demoSource;

    public void message(String message) {
        demoSource.output().send(MessageBuilder.withPayload(new DemoBean(message)).build());
        System.out.println("=========send message success:" + message);
    }
}
