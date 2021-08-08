package com.compilemind.guide.chapter01._03_use_xml;

/**
 * 我们没有使用任何的注解，
 * 而是通过在"resources/chapter01_03_use_xml_beans.xml"定义了我们的Bean
 */
public class Coconut {

    /**
     * 定义字段：重量，可以通过下面的getter和setter获取和设置该值
     */
    private int weight;

    public Coconut() {
        System.out.println("Coconut 无参构造函数");
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
