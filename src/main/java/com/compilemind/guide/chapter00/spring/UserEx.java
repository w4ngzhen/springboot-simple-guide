package com.compilemind.guide.chapter00.spring;

import org.springframework.stereotype.Component;

@Component // 使用注解，标记该类为一个组件
public class UserEx {
    public UserEx() {
        System.out.println("UserEx 无参构造函数");
    }
}
