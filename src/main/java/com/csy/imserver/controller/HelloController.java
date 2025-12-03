package com.csy.imserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        System.out.println(Thread.currentThread().toString());
        return "你好！我是原生编译的 Java 程序。c运行在: " + System.getProperty("os.name");
    }



}
