package com.haohao.demo.cloud.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haohao
 * @date 2022年09月02日 22:34
 */
@RestController
@RequestMapping("/order")
public class PayController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
