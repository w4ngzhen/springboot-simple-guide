package com.compilemind.guide.chapter02.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestB {

//    @Autowired
    private TestA testA;

    // 构造函数注入
    @Autowired
    public TestB(TestA testA) {
        this.testA = testA;
    }

    public void printTestA() {
        System.out.println("printTestA: " + this.testA);
    }
}
