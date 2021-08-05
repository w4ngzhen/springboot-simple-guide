package com.compilemind.guide.chapter00.manual;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ManualReflectionApp {

    public static void main(String[] args) {
        System.out.println("通过代码符号加载类的类型信息Class");
        loadUserClassBySymbol();

        System.out.println();

        System.out.println("通过类的全限定名称加载Class");
        loadUserClassByName();

        System.out.println();

        System.out.println("通过Class对象创建对象实例");
        createInstanceByClass();

        System.out.println();

        System.out.println("通过Class对象以及User类上的注解，完成对象的创建工作");
        createInstanceByClassAndAnnotation();

    }

    /**
     * 通过代码符号加载类的类型信息Class
     */
    public static void loadUserClassBySymbol() {
        Class<User> userClass = User.class;
        System.out.println(userClass.getCanonicalName());

        // 1. 显示声明的字段
        Field[] fields = userClass.getDeclaredFields();
        System.out.println("该类包含了如下的字段：");
        for (Field field : fields) {
            System.out.println(field);
        }

        // 2. 显示声明的方法
        Method[] methods = userClass.getDeclaredMethods();
        System.out.println("该类包含了如下的方法：");
        for (Method method : methods) {
            System.out.println(method);
        }
    }

    /**
     * 通过类的全限定名称加载Class
     */
    public static void loadUserClassByName() {
        try {
            Class<?> aClass = Class.forName(
                    "com.compilemind.guide.chapter00.manual.User");
            System.out.println(aClass.getCanonicalName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过Class对象创建对象实例
     */
    public static void createInstanceByClass() {
        try {

            // 1. 获取Class类对象
            Class<?> userClass = Class.forName(
                    "com.compilemind.guide.chapter00.manual.User");

            // 2. 展示类上的构造函数对象
            Constructor<?>[] constructors = userClass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("找到构造函数：" + constructor);
            }

            // 3. 通过无参构造函数创建实例
            Constructor<?> constructor = userClass.getConstructor();
            Object user1 = constructor.newInstance();
            System.out.println(user1);

            // 4. 通过有参构造函数创建实例
            Constructor<?> constructor1 = userClass.getConstructor(String.class, int.class);
            Object user2 = constructor1.newInstance("Mr.Hello", 18);
            System.out.println(user2);

        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InvocationTargetException
                | InstantiationException
                | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过Class对象以及User类上的注解，完成对象的创建工作
     */
    public static void createInstanceByClassAndAnnotation() {
        try {
            // 1. 获取Class类对象
            Class<?> userClass = Class.forName(
                    "com.compilemind.guide.chapter00.manual.User");

            // 2. 获取类上的 @UserInfo 注解
            UserInfo userInfo = userClass.getAnnotation(UserInfo.class);
            if (userInfo == null) {
                System.out.println(userClass.getCanonicalName() + "不包含注解" + UserInfo.class + "，终止创建");
                return;
            }

            // 3. 获取注解信息
            String name = userInfo.name();
            int age = userInfo.age();

            // 4. 通过有参构造函数，结合注解上的上下文，创建实例
            Object user = userClass.getConstructor(String.class, int.class).newInstance(name, age);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
