package com.hwy.consumer;

import com.hwy.bean.DemoBean;
import com.hwy.cons.Cons;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/21 17:21
 **/
@EnableBinding(DemoSink.class)
public class DemoConsumer {

    @StreamListener(Cons.DEMO_CHANNEL_NAME)
    public void consumer(Message<DemoBean> message) {
        System.out.println("===========consumer:" + message.getPayload());
    }
}
