package com.shf.demo5;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Circular extends Shape{
    public String name;
    public double radius;

    public Circular() {
    }

    public Circular(String name, double radius) {
        Shape.name = name;
        this.radius = radius;
    }

    public double getArea(){
        return new BigDecimal(Math.PI * Math.pow(radius, 2)).setScale(2, RoundingMode.UP).doubleValue();
    };
    public double getGirth(){
        return new BigDecimal(2 * Math.PI * radius).setScale(2, RoundingMode.UP).doubleValue();
    };
}
