package com.compilemind.guide.chapter00.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * "@SpringBootApplication" 标记是一个SpringBoot应用
 * 启动后，SpringBoot框架会去扫描当前包以及子包下（默认情况）的所有具有@Component标记的类，
 * 并通过反射的方式创建这个类的实例，存放在Spring的Bean容器中。
 */
@SpringBootApplication //
public class IocApp {
    public static void main(String[] args) {
        // 1. 启动
        ConfigurableApplicationContext context =
                SpringApplication.run(IocApp.class, args);
//        getBeanExample(context);
//        manualDependencySet(context);
        dependencyInject(context);
    }

    /**
     * 第2节 从Spring IOC容器中获取Bean
     */
    private static void getBeanExample(ConfigurableApplicationContext context) {
        // 2. 类符号获取
        System.out.println("通过类符号获取Bean");
        UserEx userEx = context.getBean(UserEx.class);
        System.out.println(userEx);

        // 3. 通过Bean的名称获取
        System.out.println("通过类符号获取Bean");
        UserEx userEx2 = (UserEx) context.getBean("userEx");
        System.out.println(userEx2);
    }

    /**
     * 第2.2节伪代码实现：手动进行依赖设置
     */
    private static void manualDependencySet(ConfigurableApplicationContext context) {
        UserEx userEx = context.getBean(UserEx.class);
        GameEx gameEx = context.getBean(GameEx.class);
        gameEx.setUserEx(userEx);
        gameEx.printUserEx();
    }

    /**
     * 如果GameEx中的字段使用@Autowired注解，
     * 不再需要上面manualDependencySet里面那样手工设置了
     */
    private static void dependencyInject(ConfigurableApplicationContext context) {
        GameEx gameEx = context.getBean(GameEx.class);
        gameEx.printUserEx(); // 同样能够得到和上述一样的输出
    }
}
