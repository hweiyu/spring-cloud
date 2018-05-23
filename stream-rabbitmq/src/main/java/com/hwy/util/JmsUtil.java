package com.hwy.util;

import com.hwy.bean.BaseBean;
import org.springframework.cloud.stream.binding.BinderAwareChannelResolver;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.util.UUID;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/23 15:41
 **/
public class JmsUtil {

    private static volatile BinderAwareChannelResolver resolver;

    private static BinderAwareChannelResolver getResolver() {
        if (resolver == null) {
            synchronized (JmsUtil.class) {
                if (resolver == null) {
                    resolver = ApplicationUtil.getBean(BinderAwareChannelResolver.class);
                }
            }
        }
        return resolver;
    }

    public static void send(String dest, BaseBean bean) {
        try {
            setVersion(bean);
            getResolver().resolveDestination(dest).send(MessageBuilder.withPayload(bean).build());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static Message<BaseBean> createMessage(BaseBean bean) {
        setVersion(bean);
        return MessageBuilder.withPayload(bean).build();
    }

    private static void setVersion(BaseBean bean) {
        bean.setVersion(UUID.randomUUID().toString().replace("-", ""));
    }
}
