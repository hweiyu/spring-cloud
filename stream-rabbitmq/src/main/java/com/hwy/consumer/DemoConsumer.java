package com.hwy.consumer;

import com.hwy.anno.Idempotent;
import com.hwy.bean.DemoMessage;
import com.hwy.cons.ChannelCons;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/21 17:21
 **/
@EnableBinding(DemoConsumer.DemoSink.class)
public class DemoConsumer implements Consumer<DemoMessage> {

    @Idempotent(previous = "consumer1")
    @StreamListener(ChannelCons.DEMO_CHANNEL_NAME)
    @Override
    public void consumer(Message<DemoMessage> message) {
        System.out.println("===========consumer:" + message.getPayload());
    }

    public interface DemoSink {
        @Input(ChannelCons.DEMO_CHANNEL_NAME)
        SubscribableChannel input();
    }
}
