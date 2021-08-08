package com.compilemind.guide.chapter02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoxA {

    private Pen pen;

    // 我们在属性setter方法上，使用@Autowire注解
    // 目的是希望Spring容器框架能够让帮助我们注入该属性
    @Autowired
    public void setPen(Pen pen) {
        this.pen = pen;
        System.out.println("setter函数注入：" + pen);
    }

    public void printPen() {
        System.out.println(pen == null ? "BoxA没有Pen" : "BoxA有Pen：" + pen);
    }

}
