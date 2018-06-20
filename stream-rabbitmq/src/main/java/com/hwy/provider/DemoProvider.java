package com.hwy.provider;

import com.hwy.bean.DemoMessage;
import com.hwy.cons.ChannelCons;
import com.hwy.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/21 17:25
 **/
@EnableBinding(value = {DemoProvider.DemoSource.class})
public class DemoProvider {

    @Autowired
    private DemoSource demoSource;

    public void message(String message) {
        demoSource.output().send(MessageUtil.createMessage(new DemoMessage(message)));
        System.out.println("=========send message success:" + message);
    }

    @Component
    public interface DemoSource {
        @Output(ChannelCons.DEMO_CHANNEL_NAME)
        MessageChannel output();
    }
}
