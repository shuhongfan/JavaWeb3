package com.shf.reflect;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {
//    读取配置文件2
    @Test
    public void test3() throws IOException {
        Properties properties = new Properties();
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
//        getResourceAsStream 配置文件默认位置 当前module的src下
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(is);

        String user = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println("user="+user+",password="+password);
    }

//    读取配置文件1
    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
//        FileInputStream  配置文件的默认位置 当前module的src下
        FileInputStream fis = new FileInputStream("src\\jdbc.properties");
        properties.load(fis);

        String user = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println("user="+user+",password="+password);
    }

    @Test
    public void test1(){
//        类加载器
//        对应自定义类 使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

//        调用系统类加载器的getParent  获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

//        调用扩展类加载器getParent  无法获取引导类的加载器
//        引导类加载主要负责加载java的核心类库  无法加载自定义类
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
    }
}
