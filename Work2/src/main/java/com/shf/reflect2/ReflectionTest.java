package com.shf.reflect2;

import com.shf.reflect2.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
    @Test
    public void testConstructor() throws Exception {
        Class<Person> clazz = Person.class;
//        获取指定的构造器
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
//        调用构造器创建运行时类
        Person tom = constructor.newInstance("tom");
        System.out.println(tom);
    }

//    操作运行时类的指定方法
    @Test
    public void testMethod() throws Exception {
        Class<Person> clazz = Person.class;
//        创建运行时类的对象
        Person person = clazz.newInstance();

//        获取指定的某个方法
//        参数1 指明获取的方法的名称
//        参数2 指明获取方法的形参列表类型
        Method show = clazz.getDeclaredMethod("show", String.class);
//        保证当前方法是可访问的
        show.setAccessible(true);
//        调用方法
//        参数1 方法的调用者
//        参数2  给方法形参赋值的实参
//        invoke的返回值即为对应类中调用的方法的返回值
        Object chn = show.invoke(person, "chn");
        System.out.println(chn);


//        调用静态方法
        Method showDescs = clazz.getDeclaredMethod("showDescs");
        showDescs.setAccessible(true);
        Object returnVal = showDescs.invoke(Person.class);
//        如果调用的运行时类中的方法没有返回值 则此invoke 返回null
        System.out.println(returnVal);
    }

    @Test
    public void testFiled1() throws Exception{
        Class<Person> clazz = Person.class;
//        创建运行时类对象
        Person p = clazz.newInstance();
//        获取运行时类指定变量名的属性
        Field name = clazz.getDeclaredField("name");
//        保证当前属性是可访问的
        name.setAccessible(true);
//        设置指定对象的属性值
        name.set(p,"武汉");
//        获取指定的属性值
        System.out.println(name.get(p));
    }

    @Test
    public void testFieldTest() throws Exception {
        Class<Person> clazz = Person.class;
//        创建运行时类的对象
        Person p = clazz.newInstance();
//        获取指定的属性
        Field id = clazz.getField("id");
        id.set(p,1001);
        Object pid = id.get(p);
        System.out.println(pid);
    }
}
