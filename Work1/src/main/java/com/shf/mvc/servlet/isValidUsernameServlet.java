package com.shf.mvc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static com.shf.mvc.beans.DbBean.isValidBJ;
import static com.shf.mvc.beans.DbBean.isValidvalidusername;

public class isValidUsernameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        Boolean validusername = true;
        try {
            validusername = isValidvalidusername(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.getWriter().write(String.valueOf(validusername));
    }
}
