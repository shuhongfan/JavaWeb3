package com.shf.reflect2;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class OtherTest {
    @Test
    public void test5(){

    }

    @Test
    public void test4(){
        Class<Person> clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
//        获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
    }

    @Test
    public void test3(){
//    获取时类的带泛型的父类的泛型
//        获取运行时类的父类 带泛型
        Class<Person> clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    @Test
    public void test2(){
//        获取运行时类的父类
        Class<Person> clazz = Person.class;
        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    @Test
    public void test1(){
//        获取构造器
        Class<Person> clazz = Person.class;
        for (Constructor<?> constructor : clazz.getConstructors()) {
            System.out.println(constructor);
        }

        for (Constructor<?> declaredConstructor : clazz.getDeclaredConstructors()) {
            System.out.println(declaredConstructor);
        }

    }
}
