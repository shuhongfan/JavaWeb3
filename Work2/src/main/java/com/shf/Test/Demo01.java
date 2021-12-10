package com.shf.Test;

import org.junit.Test;

public class Demo01 {
    @Test
    public void test() {
        String str1="java";
        String str2="java";
        String str3=new String("java");
        StringBuffer str4=new StringBuffer("java");
        System.out.println(str1==str2);
    }

    @Test
    public void test1(){
        String str="ABCDE";
        str.substring(3);
        str.concat("XYZ");
        System.out.print(str);
    }
}
