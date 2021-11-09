package com.shf.mvc.servlet;

import com.shf.mvc.beans.ScoreClass;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static com.shf.mvc.beans.DbBean.addUsername;

public class addUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        Boolean isTrue = false;
        try {
            isTrue = addUsername(username,pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("username",username);
        req.getSession().setAttribute("username",username);
        resp.getWriter().write(String.valueOf(isTrue));
    }
}
