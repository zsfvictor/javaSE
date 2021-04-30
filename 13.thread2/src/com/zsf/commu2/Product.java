package com.zsf.commu2;

/**
 * 商品类
 */
public class Product {
    private String name;//名称，馒头，玉米饼
    private String color;//颜色，白色，黄色

    public Product() {
    }

    public Product(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
