package com.shf.demo14;

import java.util.HashSet;
import java.util.Scanner;

public class Lottery {
    public static void main(String[] args) {
        HashSet<Integer> numbers = getNumbers(9);
        System.out.println(numbers);

        HashSet<Integer> scannerNumbers = getScannerNumbers(3);
        System.out.println(scannerNumbers);

        Integer compare = compare(numbers, scannerNumbers);
        System.out.println("猜中"+compare+"个数字!!!");

        if (compare==3){
            System.out.println("一等奖！！！");
        } else if (compare==2){
            System.out.println("二等奖！！！");
        } else if (compare==1) {
            System.out.println("三等奖！！！");
        } else {
            System.out.println("未中奖，继续努力！！！");
        }
    }

    public static Integer compare(HashSet<Integer> numbers,HashSet<Integer> scannerNumbers){
        Integer count = 0;
        for (Integer number : numbers) {
            for (Integer scannerNumber : scannerNumbers) {
                if (number.compareTo(scannerNumber)==0){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static HashSet<Integer> getScannerNumbers(int count){
        HashSet<Integer> scannerNumbers = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        Integer scannerNumber;
        System.out.println("请输入3个数");
        for (int i = 0; i < count; i++) {
            System.out.print("请输入第"+(i+1)+"个数：");
            scannerNumber = scanner.nextInt();
            scannerNumbers.add(scannerNumber);
        }
        return scannerNumbers;
    }

    public static HashSet<Integer> getNumbers(int count){
        HashSet<Integer> nums = new HashSet<>();
        int num;
        for (int i = 0; i < count; i++) {
            num = (int) (Math.random() * 900) + 100;
            while (nums.contains(num)){
                num = (int) (Math.random() * 900) + 100;
            }
            nums.add(num);
        }
        return nums;
    }
}

