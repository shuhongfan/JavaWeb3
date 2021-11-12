package com.shf.demo6;

public class Demo6 {
    public static void main(String[] args) {
        Human s1 = new Student("张三","231536","武汉大学","软件工程","读书");
        s1.speak();

        System.out.println("================================");

        Human w1 = new Work("李四","交通警察","维持交通畅通","跑步");
        w1.speak();
    }
}
