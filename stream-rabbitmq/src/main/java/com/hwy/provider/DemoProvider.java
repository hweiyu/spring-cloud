package com.hwy.provider;

import com.hwy.util.MessageUtil;
import com.hwy.bean.DemoBean;
import com.hwy.cons.Cons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/21 17:25
 **/
@EnableBinding(value = {DemoSource.class})
public class DemoProvider {

    @Autowired
    private DemoSource demoSource;

    public void message(String message) {
        demoSource.output().send(MessageUtil.createMessage(new DemoBean(message)));
        System.out.println("=========send message success:" + message);
    }

    //可以不用配置 MessageChannel
    public void message2(String message) {
        MessageUtil.send(Cons.DEMO2_CHANNEL_NAME, new DemoBean(message));
        System.out.println("=========send message2 success:" + message);
    }
}
