package com.hwy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/4/24 20:51
 **/
@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("hello")
    public String hello() {
        return "hello, welcome to consumer ribbon.";
    }

    @RequestMapping("remote/hello")
    public String remoteHello() {
        String url = "http://server-provider/hello";
        return "this is ribbon consumer, remote message is :" + restTemplate.getForObject(url, String.class);
    }
}
