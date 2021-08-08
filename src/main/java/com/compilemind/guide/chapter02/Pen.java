package com.compilemind.guide.chapter02;

import org.springframework.stereotype.Component;

@Component
public class Pen {
    public Pen() {
        System.out.println("Pen 无参构造函数");
    }
}
