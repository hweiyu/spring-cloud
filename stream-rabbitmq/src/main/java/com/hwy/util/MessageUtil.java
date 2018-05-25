package com.hwy.util;

import com.hwy.bean.BaseMessage;
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

    public static Message<BaseMessage> createMessage(BaseMessage message) {
        setVersion(message);
        return MessageBuilder.withPayload(message).build();
    }

    private static void setVersion(BaseMessage message) {
        message.setVersion(SonwFlakeUtil.getUniqueIdentity());
    }
}
