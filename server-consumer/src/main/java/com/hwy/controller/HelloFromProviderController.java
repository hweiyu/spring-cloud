package com.hwy.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/4/24 20:51
 **/
public class HelloFromProviderController {

    @RequestMapping("hello")
    public String hello() {
        return "hello,I'm server consumer.I get message from server provider is:";
    }
}
