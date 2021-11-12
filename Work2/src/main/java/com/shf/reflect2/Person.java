package com.shf.reflect2;

@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{
    private String name;
    int age;
    public int id;

    public Person(){

    }

    @MyAnnotation(value = "abc")
    Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    public String show(String nation){
        System.out.println("我的国籍是："+nation);
        return nation;
    }

    public String display(String intersing){
        return intersing;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    private static void showDescs(){
        System.out.println("我是一个可爱的人");
    }
}
