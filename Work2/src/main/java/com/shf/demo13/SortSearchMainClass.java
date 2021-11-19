package com.shf.demo13;

import java.util.Iterator;
import java.util.LinkedList;

public class SortSearchMainClass {
    public static void main(String[] args) {
        LinkedList<Book> bookList = new LinkedList<>();
        Book java = new Book("JAVA", 59.9);
        Book photoshop = new Book("Photoshop", 59.9);
        Book php = new Book("PHP", 29.9);
        Book mysql = new Book("MySQL", 49.9);
        bookList.add(java);
        bookList.add(photoshop);
        bookList.add(php);
        bookList.add(mysql);

//        新书
        Book go = new Book("GO", 59.9);

        System.out.println("新书："+go);
        System.out.println("与新书价格相等的书为：");
        for (Book book : bookList) {
            if (go.getPrice().compareTo(book.getPrice()) == 0) {
                System.out.println(book);
            }
        }
    }
}
