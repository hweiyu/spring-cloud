package com.hwy.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/4/25 14:06
 **/
@FeignClient("server-provider")
public interface HelloService {

    @GetMapping("hello")
    String remoteHello();
}
