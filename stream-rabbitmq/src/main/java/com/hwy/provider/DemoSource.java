package com.hwy.provider;

import com.hwy.cons.Cons;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public interface DemoSource {

    @Output(Cons.DEMO_CHANNEL_NAME)
    MessageChannel output();
}
