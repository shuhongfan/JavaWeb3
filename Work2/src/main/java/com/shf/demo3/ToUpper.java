package com.shf.demo3;

import java.util.Scanner;

public class ToUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.print("请输入任意字符：");
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i]=='#') flag=false;
                if (chars[i]>='a' && chars[i]<='z') chars[i]-=32;
            }
            System.out.print("格式化后字符：");
            for (char ch : chars) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
