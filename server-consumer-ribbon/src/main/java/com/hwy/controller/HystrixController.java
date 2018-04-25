package com.hwy.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    public String remoteHystrix() {
        String url = "http://server-provider/hystrix";
        return restTemplate.getForObject(url, String.class);
    }

    @RequestMapping("remote/hystrix2")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "6000"),
            @HystrixProperty(name = "execution.timeout.enabled", value = "false")},
            fallbackMethod = "fallback")
    public String remoteHystrix2() {
        String url = "http://server-provider/hystrix";
        return restTemplate.getForObject(url, String.class);
    }

    public String fallback() {
        return "remote call is fallback!";
    }
}
