package com.compilemind.guide.chapter01._02_use_configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Chapter01Configuration {
    @Bean
    public Banana myBanana() { // 方法名即为Bean的名称
        System.out.println("进入Banana Bean创建函数");
        return new Banana();
    }
}
