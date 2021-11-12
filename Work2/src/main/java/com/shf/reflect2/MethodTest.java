package com.shf.reflect2;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MethodTest {
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
//        获取方法声明的注解
        for (Method method : clazz.getDeclaredMethods()) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation anno : annotations) {
                System.out.println(anno);
            }

            Class<?> returnType = method.getReturnType();
        }
    }

    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
//        getMethods 获取当前运行时类及其父类声明为public权限方法
        for (Method method : clazz.getMethods()) {
            System.out.println(method);
        }
        System.out.println("-----------------------");

//        getDeclaredMethods   获取当前运行时类中声明的所有方法  不包含父类中声明的方法
        for (Method declaredMethod : clazz.getDeclaredMethods()) {
            System.out.println(declaredMethod);
        }

    }
}
