package com.compilemind.guide.chapter02.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestA {

    // 字段注入
//    @Autowired
    private TestB testB;

    // 构造函数注入
    @Autowired
    public TestA(TestB testB) {
        this.testB = testB;
    }

    public void printTestB() {
        System.out.println("printTestB: " + this.testB);
    }
}
