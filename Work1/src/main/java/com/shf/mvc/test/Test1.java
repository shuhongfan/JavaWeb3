package com.shf.mvc.test;

import org.junit.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static com.shf.mvc.beans.DbBean.countUser;
import static com.shf.mvc.beans.DbBean.showUserInfoPages;

public class Test1 {
    @Test
    public void test1() {
        Integer integer = null;
        try {
            integer = countUser("200201011");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(integer);
    }

    @Test
    public void test2() {
        List<List<String>> lists = null;
        try {
            lists = showUserInfoPages(Arrays.asList("200201011", "2", "2"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
}
