package com.hwy.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/4/25 20:17
 **/
@RestController
public class HystrixController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("remote/hystrix")
    @HystrixCommand(fallbackMethod = "fallback")
    public String remoteHello() {
        String url = "http://server-provider/hystrix";
        return restTemplate.getForObject(url, String.class);
    }

    public String fallback() {
        return "remote call is fallback!";
    }
}
