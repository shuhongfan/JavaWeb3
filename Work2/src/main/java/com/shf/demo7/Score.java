package com.shf.demo7;

import java.util.Scanner;

class MyException extends Exception{
    String msg;
    MyException(Double err){
        msg = "分数不合法，分数应该在0-100分之间";
    }
}

class scoreError{
    public scoreError(Double score) throws MyException{
        if (score>100 || score<0){
            throw new MyException(score);
        }
    }
}

public class Score {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pass = 0;
        double passScore = 0;
        int fail = 0;
        double failScore = 0;
        System.out.print("请输入班级人数：");
        int num = scanner.nextInt();
        double score=0;
        for (int i = 0; i < num; i++) {
            System.out.print("请输入"+(i+1)+"个分数：");
            score = scanner.nextDouble();
            try {
                new scoreError(score);
            } catch (MyException e) {
                System.out.println(e.msg);
                System.out.print("请重新输入"+(i+1)+"个分数：");
                score = scanner.nextDouble();
            } finally {
                if (score>=60) {
                    pass++;
                    passScore += score;
                } else {
                    fail++;
                    failScore += score;
                }
            }
        }

        System.out.println("及格人数："+pass);
        System.out.println("及格人数平均分："+passScore/pass);
        System.out.println("不及格人数："+fail);
        System.out.println("不及格人数平均分："+failScore/fail);
    }
}
