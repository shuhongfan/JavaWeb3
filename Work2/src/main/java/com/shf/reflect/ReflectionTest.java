package com.shf.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Period;

public class ReflectionTest {
    @Test
    public void test3() throws ClassNotFoundException {
//        Class的实例对应着一个运行时类
//        加载到内存中的运行时类,会缓存一段时间,可以通过不同的方式来获取次运行时类

//        获取Class的实例方式
//        方式1  调用运行时类的属性 .class
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);

//        方式2 通过运行时类的对象 调用getClass
        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass();
        System.out.println(clazz2);

//        方式3  调用Class的静态方法 forname
        Class<?> clazz3 = Class.forName("com.shf.reflect.Person");
        System.out.println(clazz3);

        System.out.println(clazz1==clazz2);
        System.out.println(clazz2==clazz3);

//        方式4  实用类的加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.shf.reflect.Person");
        System.out.println(clazz4);
        System.out.println(clazz4==clazz1);
    }

//    关于java.lang.Class类的理解
//    1.类的加载过程
//    程序经过javac.exe命令以后,会生成一个或多个字节码文件 .class结尾,接着我们使用java.exe命令对某个字节码文件进行解释运行.
//    相当于将某个字节码文件加载到内存中.此过程就称为类的加载
//    加载内存中的类,我们就称为运行时类,此运行时类,就作为Class的实例
    @Test
    public void test2() throws Exception {
        Class<Person> clazz = Person.class;
//        通过反射 创建person类对象
        Constructor constructors = clazz.getConstructor(String.class, int.class);
        Person p = (Person) constructors.newInstance("p", 12);
        System.out.println(p);

//        通过反射 调用对象指定的属性/方法
        Field age = clazz.getDeclaredField("age");
        System.out.println(p);
        age.set(p,10);
        System.out.println(p);

//        调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

//        通过反射 调用Person类的私有方法和私有属性
        Constructor<Person> declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person p1 = declaredConstructor.newInstance("jerry");
        System.out.println(p1);

//        调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"HanMeimei");
        System.out.println(p1);

//        调用私有方法
        Method showNatioName = clazz.getDeclaredMethod("showNatioName", String.class);
        showNatioName.setAccessible(true);
        String nation = (String) showNatioName.invoke(p1, "USA");
        System.out.println(nation);
    }

    @Test
    public void test1(){
        Person p1 = new Person("tom", 12);
        p1.age=10;
        System.out.println(p1);

        p1.show();
//        在person外部 不可以通过person类的对象调用内部私有结构
    }
}
