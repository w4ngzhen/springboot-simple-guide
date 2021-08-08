package com.compilemind.guide.chapter01._01_use_annotation;

import org.springframework.stereotype.Component;

// 使用注解 @Component 标记，并且我们还自定义了Bean的名称
@Component("myApple")
public class Apple {

    public Apple() {
        System.out.println("Apple 无参构造函数");
    }

}
