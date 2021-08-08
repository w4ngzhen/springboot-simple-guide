package com.compilemind.guide.chapter02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoxB {

    private Pen pen;

    // 在构造函数上添加@Autowired注解，并且构造函数入参有Pen
    @Autowired
    public BoxB(Pen pen) {
        this.pen = pen;
        System.out.println("BoxB 有参构造函数，注入Pen实例：" + pen);
    }

    public void printPen() {
        System.out.println(pen == null ? "BoxB没有Pen" : "BoxB有Pen：" + pen);
    }
}
