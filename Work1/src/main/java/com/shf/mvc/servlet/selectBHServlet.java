package com.shf.mvc.servlet;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static com.shf.mvc.beans.DbBean.selectBH;

public class selectBHServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        List<String> bjmc = null;
        try {
            bjmc = selectBH();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.getWriter().println(new Gson().toJson(bjmc));
        resp.getWriter().flush();
    }
}
