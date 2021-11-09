package com.shf.mvc.servlet;

import com.shf.mvc.beans.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String[] hobbies = req.getParameterValues("hobby");
        User user = new User(username, password, gender, Arrays.asList(hobbies));
        System.out.println(user);
        req.setAttribute("username",username);
        req.setAttribute("password",password);
        req.setAttribute("gender",gender);
        req.setAttribute("hobby",hobbies);
        req.getRequestDispatcher("/demo7/regist.jsp").forward(req,resp);
    }
}
