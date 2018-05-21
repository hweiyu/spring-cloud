package com.hwy.controller;

import com.hwy.provider.DemoProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/5/21 17:17
 **/
@RestController
public class MessageController {

    @Autowired
    protected DemoProvider demoProvider;

    @RequestMapping(value = "provider/{message}")
    public String sendMessage(@PathVariable("message") String message) {
        demoProvider.provider(message);
        return "send success";
    }
}
