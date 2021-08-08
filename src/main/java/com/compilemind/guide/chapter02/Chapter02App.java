package com.compilemind.guide.chapter02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Chapter02App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(Chapter02App.class, args);
//        injectBySetter(context);

//        injectByConstruct(context);

        injectByField(context);
    }

    /**
     * 使用setter方法注入方式的测试样例
     */
    private static void injectBySetter(ConfigurableApplicationContext context) {
        Object box = context.getBean("boxA");
        if (box instanceof BoxA) {
            System.out.println("BoxA实例：" + box);
            ((BoxA) box).printPen(); // BoxA 能够正确打印Pen实例
        }
    }

    /**
     * 使用构造函数方式注入的测试样例
     */
    private static void injectByConstruct(ConfigurableApplicationContext context) {
        Object boxB = context.getBean("boxB");
        if (boxB instanceof BoxB) {
            System.out.println("BoxB 实例：" + boxB);
            ((BoxB) boxB).printPen(); // BoxB 能够正确打印Pen实例
        }
    }

    /**
     * 使用构造函数方式注入的测试样例
     */
    private static void injectByField(ConfigurableApplicationContext context) {
        Object boxC = context.getBean("boxC");
        if (boxC instanceof BoxC) {
            System.out.println("BoxC 实例：" + boxC);
            ((BoxC) boxC).printPen(); // BoxC 能够正确打印Pen实例
        }
    }
}
