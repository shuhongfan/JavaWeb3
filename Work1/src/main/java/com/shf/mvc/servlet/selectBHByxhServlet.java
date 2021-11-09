package com.shf.mvc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static com.shf.mvc.beans.DbBean.selectBHBybh;

public class selectBHByxhServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");
        String bh = req.getParameter("bh");
        String bjmc = null;
        try {
            bjmc = selectBHBybh(bh);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.getWriter().write(bjmc);
    }
}
