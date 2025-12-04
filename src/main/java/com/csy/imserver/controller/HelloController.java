package com.csy.imserver.controller;

import com.csy.imserver.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        System.out.println(Thread.currentThread().getName());
        return "你好！我是原生编译的 Java 程序。a运行在: " + System.getProperty("os.name");
    }


    @GetMapping("/t1")
    public User t1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 使用反射创建对象，并赋值 返回
        try {
            String packageName = "com.csy.imserver.entity";
            String className = "User";
            Class<?> clazz = Class.forName(packageName + "." + className);
            User user = (User) clazz.newInstance();
            user.setName("张三");
            user.setPassword("<PASSWORD>");
            user.setEmail("<EMAIL>");
            user.setPhone("12345678901");
            user.setAvatar("https://avatars.githubusercontent.com/u/10251060?s=200&v=4");
            user.setSex("男");
            user.setBirthday("1990-01-01");
            return user;
        } catch (Exception e) {
            System.out.println("反射失败：" + e.getMessage());
            return null;
        }

    }


}
