package com.shf.demo5;

public class ShapeDemo {
    public static void main(String[] args) {
        Shape circular = new Circular("圆形",5);
        System.out.println(Shape.name+"--->周长为："+circular.getGirth());
        System.out.println(Shape.name+"--->圆的面积为："+circular.getArea());

        Shape triangle = new Triangle("三角形",5,6,7);
        System.out.println(Shape.name + "--->周长为："+triangle.getGirth());
        System.out.println(Shape.name + "--->的面积为："+triangle.getArea());
    }
}
