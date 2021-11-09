package com.shf.mvc.servlet;

import com.shf.mvc.beans.ScoreClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static com.shf.mvc.beans.DbBean.addBj;

public class addBjServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bjbn = req.getParameter("bjbn");
        String bjmc = req.getParameter("bjmc");
        ScoreClass scoreClass = new ScoreClass(bjbn, bjmc);
        Boolean isTrue = false;
        try {
            isTrue = addBj(scoreClass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.getWriter().write(String.valueOf(isTrue));
    }
}
