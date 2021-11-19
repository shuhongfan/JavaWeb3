package com.shf.demo12;

public class Remittance {
    public static void main(String[] args) {
        Customer c1 = new Customer("张三");
        Customer c2 = new Customer("李四");

        c1.start();
        c2.start();
    }
}

class Customer extends Thread{
    private String name;
    public Customer(String name){
        this.name = name;
    }

    @Override
    public void run() {
//        存入3次  每次100
        for (int i = 0; i < 3; i++) {
            Bank.save(name,100);
        }
    }
}

class Bank{
//    余额
    private static int balance = 0;
    //用synchronized关键字设定该方法为线程同步的
    public synchronized static void save(String name,double money) {
        try {
            //利用sleep（）方法令当前正在执行的线程进入休眠状态，且参数类型必须为int
            Thread.sleep((int) (Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        balance+=money;
        System.out.print(name+" 存入 "+money+"元, ");
        System.out.println("余额："+balance+"元");
    }
}
