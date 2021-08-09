package com.compilemind.guide.chapter04_05.model;

public class Book {
    /**
     * 书籍ID
     */
    private String id;
    /**
     * 书籍名称
     */
    private String name;
    /**
     * 书籍价格
     */
    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
