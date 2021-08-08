package com.compilemind.guide.chapter02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoxC {

    @Autowired
    private Pen pen;

    public void printPen() {
        System.out.println(pen == null ? "BoxC没有Pen" : "BoxC有Pen：" + pen);
    }
}
