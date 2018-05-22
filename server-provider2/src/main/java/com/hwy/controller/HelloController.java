package com.hwy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/4/24 20:37
 **/
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello, welcome to provider2";
    }
}
