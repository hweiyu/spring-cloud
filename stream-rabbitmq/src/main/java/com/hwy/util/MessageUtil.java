package com.hwy.util;

import com.hwy.bean.BaseMessage;
import com.hwy.cons.Cons;
import org.springframework.cloud.stream.binding.BinderAwareChannelResolver;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/23 15:41
 **/
public class MessageUtil {

    private static volatile BinderAwareChannelResolver resolver;

    private static BinderAwareChannelResolver getResolver() {
        if (resolver == null) {
            synchronized (MessageUtil.class) {
                if (resolver == null) {
                    resolver = ApplicationUtil.getBean(BinderAwareChannelResolver.class);
                }
            }
        }
        return resolver;
    }

    public static void send(String dest, BaseMessage message) {
        try {
            getResolver().resolveDestination(dest).send(createMessage(message));
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    /**
     * 通过setHeader设置全局唯一标识，用于消费者端幂等处理
     * @param message
     * @return
     */
    public static Message<BaseMessage> createMessage(BaseMessage message) {
        return MessageBuilder
                .withPayload(message)
                .setHeaderIfAbsent(Cons.UNIQUE_IDENTITY, SnowFlakeUtil.getUniqueIdentity())
                .build();
    }

}
