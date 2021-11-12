package com.shf.reflect;

import org.junit.Test;

import java.util.Random;

public class NewInstanceTest {
//    反射的动态性
    @Test
    public void test2(){
        int num = new Random().nextInt(3);
        String classPath="";
        switch (num){
            case 0:
                classPath = "java.util.Date";
                break;
            case 1 :
                classPath ="java.lang.Object";
                break;
            case 2:
                classPath = "com.shf.reflect.Person";
                break;
        }
        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Object getInstance(String classPath) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }

    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
//        newInstance  调用此方法 创建对应的运行时类的对象
//        内部调用运行时类的空参的构造器
//        空参的构造器的访问权限要够  通常 设置为public

//        在javabean中要求提供一个public空参构造器
        Person person = clazz.newInstance();
        System.out.println(person);
    }
}
