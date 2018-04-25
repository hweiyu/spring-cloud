package com.hwy.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * 使用了@HystrixCommand来将某个函数包装成了Hystrix命令，
 * 这里除了定义服务降级之外，Hystrix框架就会自动的为这个
 * 函数实现调用的隔离。所以，依赖隔离、服务降级在使用时
 * 候都是一体化实现的，这样利用Hystrix来实现服务容错保护
 * 在编程模型上就非常方便的，并且考虑更为全面。
 *
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

    /**
     * 服务降级测试
     * @return
     */
    @RequestMapping("remote/hystrix")
    @HystrixCommand(fallbackMethod = "fallback")
    public String remoteHystrix() {
        String url = "http://server-provider/hystrix";
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * 服务降级测试
     * @return
     */
    @RequestMapping("remote/hystrix2")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
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
