package com.shf.mvc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class loginSerVlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username="+username);
        System.out.println("password="+password);
        System.out.println(username.equals("abc") && password.equals("123"));
        if (username.equals("abc") && password.equals("123")){
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            resp.sendRedirect("/demo6/protect/success.jsp");
        } else {
            req.setAttribute("info","用户名或密码错错误");
            req.getRequestDispatcher("/demo6/login.jsp").forward(req,resp);
        }
    }
}
