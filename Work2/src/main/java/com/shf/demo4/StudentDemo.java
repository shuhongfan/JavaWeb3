package com.shf.demo4;

import java.util.Scanner;

public class StudentDemo {
    public static void main(String[] args) {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入学生学号：");
        String studentId = scanner.nextLine();
        student.setStudentId(studentId);

        System.out.print("请输入学生姓名：");
        String name = scanner.nextLine();
        student.setName(name);

        System.out.print("请输入学生性别：（1---男，0----女）");
        boolean gender ;
        if (scanner.nextInt() == 1) gender=true;
        else gender=false;
        student.setGender(gender);

        System.out.print("请输入学生是否为班干部：（1---是，0----否）");
        boolean isClassLeader ;
        if (scanner.nextInt() == 1) isClassLeader=true;
        else isClassLeader=false;
        student.setClassLeader(isClassLeader);

        System.out.print("请输入学生语文成绩：");
        double chineseScore = scanner.nextDouble();
        student.setChineseScore(chineseScore);

        System.out.print("请输入学生数学成绩：");
        double mathScore = scanner.nextDouble();
        student.setMathScore(mathScore);

        System.out.print("请输入学生英语成绩：");
        double englishScore = scanner.nextDouble();
        student.setEnglishScore(englishScore);

        System.out.println("======================================");
        System.out.println(student);
        System.out.println("学生的总成绩为："+student.getSum());
        System.out.println("学生的平均成绩为："+student.getAvg());
    }
}
