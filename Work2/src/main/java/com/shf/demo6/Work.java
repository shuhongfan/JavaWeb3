package com.shf.demo6;

public class Work implements Human{
    private String name;
    private String work;
    private String duties;
    private String hobby;

    public Work() {
    }

    public Work(String name, String work, String duties, String hobby) {
        this.name = name;
        this.work = work;
        this.duties = duties;
        this.hobby = hobby;
    }

    @Override
    public void speak() {
        System.out.println("我的名字是："+name);
        System.out.println("我的工作单位是："+work);
        System.out.println("我的职务是："+duties);
        System.out.println("我的兴趣爱好是："+hobby);
    }
}
