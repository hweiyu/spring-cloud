package com.hwy.consumer;

import com.hwy.cons.ChannelCons;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/21 17:21
 **/
@EnableBinding(DeadLetterConsumer.DeadLetterSink.class)
public class DeadLetterConsumer implements Consumer {

    @StreamListener(ChannelCons.DEAD_LETTER_CHANNEL_NAME)
    @Override
    public void consumer(Message message) {
        System.out.println("===========dead letter consumer:" + message.getHeaders());
        System.out.println("===========dead letter consumer:" + message.getPayload());
    }

    @Component
    public interface DeadLetterSink {
        @Input(ChannelCons.DEAD_LETTER_CHANNEL_NAME)
        SubscribableChannel input();
    }
}
