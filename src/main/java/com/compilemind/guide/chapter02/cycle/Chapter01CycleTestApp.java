package com.compilemind.guide.chapter02.cycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Chapter01CycleTestApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(Chapter01CycleTestApp.class, args);
        TestA testA = context.getBean(TestA.class);
        TestB testB = context.getBean(TestB.class);
        System.out.println("从容器中获取的TestA实例：" + testA);
        testA.printTestB();

        System.out.println("从容器中获取的TestB实例：" + testB);
        testB.printTestA();
    }
}
