package com.shf.demo6;

public class Student implements Human{
    private String name;
    private String studentId;
    private String schoolName;
    private String major;
    private String hobby;

    public Student() {
    }

    public Student(String name, String studentId, String schoolName, String major, String hobby) {
        this.name = name;
        this.studentId = studentId;
        this.schoolName = schoolName;
        this.major = major;
        this.hobby = hobby;
    }

    @Override
    public void speak() {
        System.out.println("我的名字叫："+name);
        System.out.println("我的学号是："+studentId);
        System.out.println("我的学校名字叫："+schoolName);
        System.out.println("我的专业是："+major);
        System.out.println("我的兴趣爱好是："+hobby);
    }
}
