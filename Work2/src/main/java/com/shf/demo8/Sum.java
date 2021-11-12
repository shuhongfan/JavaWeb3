package com.shf.demo8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sum {
    public static void main(String[] args) {
//        String str = "love23next234csdn3423javaeye1024";
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字符串包含数字：");
        String str = scanner.nextLine();

        Matcher matcher = Pattern.compile("[^0-9]").matcher(str);

        String numStr = matcher.replaceAll(",");
        List<String> strList = new ArrayList<String>(Arrays.asList(numStr.split(",")));
        System.out.println(strList);

        strList.removeAll(Arrays.asList(""));
        System.out.println(strList);

        int sum = 0;
        for (int i = 0; i < strList.size(); i++) {
             sum += Integer.parseInt(strList.get(i));
        }
        System.out.println("sum= "+sum);
    }
}
