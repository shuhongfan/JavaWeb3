package com.shf.demo11;

import java.io.*;
import java.util.Scanner;

public class IOTest {
    public static void main(String[] args) {
        writeFile("D:\\Develop\\upload\\demo.txt");

        readFile("D:\\Develop\\upload\\demo.txt");
    }

    public static void readFile(String filePath){
        //创建一个读取文件的流对象
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //bufferreader进行了一下封装，是读取的效率更高
        BufferedReader bufferedReader = null;
        if (fileReader != null) {
            bufferedReader = new BufferedReader(fileReader);
        }

        String str;
        //bufferedReader.readLine()是读取文件的一行，如果有多行，会逐行读取。
        //当每一行不为空时则把内容打印到控制台中，也可以存到写入的流中，把内容写到文本里
        while(true) {
            try {
                if (!((str = bufferedReader.readLine())!= null)) {
                    break;
                }
                System.out.println(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //最后不要忘记关流
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(String filePath){
        System.out.print("请输入多行字符串(输入‘-1’结束输入)：");
        Scanner scanner = new Scanner(System.in);
        String str = "";
        while(true){
            String s = scanner.nextLine();
            if (s.equals("-1")){
                break;
            }
            str += s;
            str += "\r\n";
        }
        File f=new File(filePath);

        //字节流输出
        FileOutputStream fos=null;
        try {
            fos=new FileOutputStream(f);
            fos.write(str.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
