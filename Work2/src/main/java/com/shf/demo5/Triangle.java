package com.shf.demo5;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Triangle extends Shape{
    public String name;
    public double a;
    public double b;
    public double c;

    public Triangle() {
    }

    public Triangle(String name, double a, double b, double c) {
        Shape.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getArea(){
        double p = getGirth() / 2.0;
        return new BigDecimal(Math.sqrt(p*(p-a)*(p-b)*(p-c))).setScale(2, RoundingMode.UP).doubleValue();
    };
    public double getGirth(){
        return a + b + c;
    };
}
