package com.shf.demo3;

import java.math.BigDecimal;
import java.util.Scanner;

public class Source {
    public static void main(String[] args) {
        double num;
        double max;
        double min;
        double sum = 0.0;
        double average;
        int count = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入第"+(count+1)+"个学生的成绩(输入负数结束输入)：");
        num = scanner.nextDouble();
        max=min=num;
        count++;
        sum += num;
        while (true){
            System.out.print("请输入第"+(count+1)+"个学生的成绩(输入负数结束输入)：");
            num = scanner.nextDouble();
            if (num < 0) break;
            if (num > max) max=num;
            if (num < min) min=num;
            count++;
            sum += num;
        }
        average = new BigDecimal(sum / count).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();

        System.out.println("最高成绩："+max);
        System.out.println("最低成绩："+min);
        System.out.println("平均成绩："+average);
    }
}
