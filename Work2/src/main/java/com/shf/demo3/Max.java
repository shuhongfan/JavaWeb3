package com.shf.demo3;

public class Max {
    public static void main(String[] args) {
        int n = 0,sum = 0;
        for (int i = 1; sum < 8888; i++) {
            n++;
            sum += n;
        }
        System.out.println("满足1+2+3+……+n<8888的最大正整数为:"+(n-1));
    }
}
