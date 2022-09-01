package com.haohao.elk.controller;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haohao
 * @date 2022年09月01日 14:56
 */
@Slf4j
@RestController
public class TestController {


    @GetMapping("/test")
    public void test() {
        log.info("date time :{}", DateUtil.now());
    }
}
