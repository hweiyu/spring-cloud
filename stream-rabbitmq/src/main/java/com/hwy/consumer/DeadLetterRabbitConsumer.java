package com.hwy.consumer;

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
 * @Description: 死信队列
 * @date 2018/6/21 9:15
 **/
@EnableBinding({DeadLetterRabbitConsumer.Sink.class})
public class DeadLetterRabbitConsumer {

    /**
     * 死信队列消费者
     * @param message
     * @throws Exception
     */
    @StreamListener(ChannelCons.DEAD_LETTER_CHANNEL_NAME)
    public void consumer(Message message) throws Exception {
        System.out.println("==============dead letter:" + new String((byte[]) message.getPayload()));
        //todo handle dead mq
    }

    public interface Sink {
        @Input(ChannelCons.DEAD_LETTER_CHANNEL_NAME)
        SubscribableChannel input();
    }

}
