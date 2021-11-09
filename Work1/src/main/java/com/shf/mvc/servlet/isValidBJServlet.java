package com.shf.mvc.servlet;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import static com.shf.mvc.beans.DbBean.isValidBJ;

public class isValidBJServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bh = req.getParameter("bh");
        Boolean validBJ = true;
        try {
            validBJ = isValidBJ(bh);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.getWriter().write(String.valueOf(validBJ));
    }
}
