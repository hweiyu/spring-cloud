package com.hwy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangweiyu
 * @version V1.0
 * @Title: 描述
 * @Description: 描述
 * @date 2018/4/25 20:17
 **/
@RestController
public class HystrixController {

    @RequestMapping("/hystrix")
    public String hystrix() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "this message from provider hystrix test!";
    }

}
