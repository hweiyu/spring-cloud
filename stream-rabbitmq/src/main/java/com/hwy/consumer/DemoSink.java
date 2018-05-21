package com.hwy.consumer;

import com.hwy.cons.Cons;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface DemoSink {

    @Input(Cons.DEMO_CHANNEL_NAME)
    SubscribableChannel input();
}
