package com.hwy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
        return "hello, welcome to provider";
    }

    @RequestMapping("/trace")
    public String trace(HttpServletRequest request) {
        System.out.println("=====provider call method: /trace");
        System.out.println("=====provider call method: /trace, TraceId={"
                + request.getHeader("X-B3-TraceId") + "}, SpanId={"
                + request.getHeader("X-B3-SpanId") + "}>===");
        return "trace, welcome to provider";
    }
}
