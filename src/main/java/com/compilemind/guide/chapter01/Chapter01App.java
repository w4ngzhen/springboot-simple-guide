package com.compilemind.guide.chapter01;

import com.compilemind.guide.chapter01._02_use_configuration.Banana;
import com.compilemind.guide.chapter01._02_use_configuration.Chapter01Configuration;
import com.compilemind.guide.chapter01._03_use_xml.Coconut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication

// '@Import' 注解用于指定我们需要的配置类
// 默认情况下，会自动扫描当前启动类所在包及其子包的Configuration，
// 所以不需要特别指定，这里主要是演示
@Import(Chapter01Configuration.class)

// '@ImportResource' 注解用于加载我们指定的xml配置
@ImportResource("classpath:chapter01_03_use_xml_beans.xml")
public class Chapter01App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(Chapter01App.class, args);

        useAnnotation(context);

        useConfiguration(context);

        useXml(context);
    }

    /**
     * 获取 使用 '@Component' 注解标记的Bean
     */
    private static void useAnnotation(ConfigurableApplicationContext context) {
        // 注意BeanName我们填写的"myApple"，和 @Component("myApple") 对应
        Object myApple = context.getBean("myApple");
        System.out.println(myApple);
    }

    /**
     * 使用配置类的演示
     * 需要注意的是，启动类上有：
     *
     */
    private static void useConfiguration(ConfigurableApplicationContext context) {
        Object myBanana = context.getBean("myBanana");
        System.out.println(myBanana);
        Object myBanana2 = context.getBean("myBanana");
        System.out.println(myBanana2);
    }

    /**
     * 使用XML配置Bean的演示
     * 需要注意的是，启动类上需要有：
     * '@ImportResource("classpath:chapter01_03_use_xml_beans.xml")'
     */
    private static void useXml(ConfigurableApplicationContext context) {
        Object myCoconut = context.getBean("myCoconut");
        if (myCoconut instanceof Coconut) {
            int weight = ((Coconut) myCoconut).getWeight();
            System.out.println("Coconut 重量是：" + weight);
        }
    }
}
