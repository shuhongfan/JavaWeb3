package com.shf.reflect2;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
//            权限修饰符
            int modifiers = declaredField.getModifiers();
            System.out.println(Modifier.toString(modifiers));

//            数据类型
            Class<?> type = declaredField.getType();
            System.out.println(type);


            String name = declaredField.getName();
            System.out.println(name);
        }
    }

    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
//        获取属性结构
//        getFields 获取当前运行时类及其父类中声明为public访问权限属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

//        getDeclaredFields  获取当前运行时类中声明的所有属性
        for (Field declaredField : clazz.getDeclaredFields()) {
            System.out.println(declaredField);
        }
    }
}
