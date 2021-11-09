package com.shf.mvc.beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DbBean {
    public static Connection con;

    static {
        try {
            con = getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root", "root");
        return con;
    }

    public static void closeConnection() throws SQLException {
        con.close();
    }

    public static void addUser(List<String> pars) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("insert into score values (?,?,?,?,?,?,?)");

        preparedStatement.setString(1, pars.get(0));
        preparedStatement.setString(2, pars.get(1));
        preparedStatement.setString(3, pars.get(2));
        preparedStatement.setString(4, pars.get(3));
        preparedStatement.setString(5, pars.get(4));
        preparedStatement.setString(6, pars.get(5));
        preparedStatement.setString(7, pars.get(6));
        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    public static void alterUser(List<String> pars) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("update score set xm=?,bh=?,sx=?,yy=?,yw=?,zf=? where xh=?");

        preparedStatement.setString(1, pars.get(0));
        preparedStatement.setString(2, pars.get(1));
        preparedStatement.setString(3, pars.get(2));
        preparedStatement.setString(4, pars.get(3));
        preparedStatement.setString(5, pars.get(4));
        preparedStatement.setString(6, pars.get(5));
        preparedStatement.setString(7, pars.get(6));
        System.out.println(preparedStatement);

        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    public static void deleteUser(String xh) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("delete from score where xh=?");
        preparedStatement.setString(1, xh);
        preparedStatement.executeUpdate();

        preparedStatement.close();
    }

    public static List<String> showUserInfo(List<String> pars) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("select * from score where xh=?");
        preparedStatement.setString(1, pars.get(0));
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        String bh = resultSet.getString("bh");
        String xh = resultSet.getString("xh");
        String xm = resultSet.getString("xm");
        String yw = resultSet.getString("yw");
        String sx = resultSet.getString("sx");
        String yy = resultSet.getString("yy");
        String zf = resultSet.getString("zf");
        preparedStatement.close();
        return Arrays.asList(bh, xh, xm, yw, sx, yy, zf);
    }

    public static Integer countUser(String bh) throws SQLException {
        PreparedStatement countSql = con.prepareStatement("select count(*) cou from score where bh=?");
        countSql.setString(1, bh);
        ResultSet countN = countSql.executeQuery();
        countN.next();
        Integer cou = Integer.parseInt(countN.getString("cou"));
        System.out.println("cou="+cou);
        countSql.close();
        return cou;
    }

    public static List<List<String>> showUserInfoPages(List<String> pars) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("select * from score where bh=? limit ?,? ");
        preparedStatement.setString(1, (String) pars.get(0));
        preparedStatement.setInt(2, Integer.parseInt(pars.get(1)));
        preparedStatement.setInt(3, Integer.parseInt(pars.get(2)));
        ResultSet resultSet = preparedStatement.executeQuery();
        List<List<String>> list = new ArrayList<>();
        while (resultSet.next()) {
            String xh = resultSet.getString("xh");
            String xm = resultSet.getString("xm");
            String bh = resultSet.getString("bh");
            String zf = resultSet.getString("zf");
            list.add(Arrays.asList(xh,xm,bh,zf));
        }
        preparedStatement.close();
        return list;
    }

    public static String selectBHBybh(String bh) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("select bjmc from class where bjbn=?");
        preparedStatement.setString(1, bh);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        String bjmc = resultSet.getString("bjmc");
        preparedStatement.close();
        return bjmc;
    }

    public static List<String> selectBH() throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("select distinct bjmc from class");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<String> list = new ArrayList<>();
        while (resultSet.next()) {
            String bjmc = resultSet.getString("bjmc");
            list.add(bjmc);
        }
        preparedStatement.close();
        return list;
    }

    public static  List<List<String>> selectXSByBH(String bh) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("select xh,xm from score where bh=(select bjbn from class where bjmc = ?)");
        preparedStatement.setString(1, bh);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<List<String>> list = new ArrayList<>();
        while (resultSet.next()) {
            String xh = resultSet.getString("xh");
            String xm = resultSet.getString("xm");
            list.add(Arrays.asList(xh,xm));
        }
        preparedStatement.close();
        return list;
    }

    public static Boolean isValidBJ(String bh) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("select * from class where bjbn=?");
        preparedStatement.setString(1, bh);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return false;
        }
        return true;
    }

    public static Boolean addBj(ScoreClass scoreClass) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("insert into class values (?,?)");
        preparedStatement.setString(1, scoreClass.getBjbn());
        preparedStatement.setString(2, scoreClass.getBjmc());
        int row = preparedStatement.executeUpdate();
        preparedStatement.close();
        if (row>0) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean isValidvalidusername(String username) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("select * from user where username=?");
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return false;
        }
        return true;
    }

    public static Boolean addUsername(String username,String pwd) throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("insert into user(username,password) values (?,?)");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, pwd);
        int row = preparedStatement.executeUpdate();
        preparedStatement.close();
        if (row>0) {
            return true;
        } else {
            return false;
        }
    }
}