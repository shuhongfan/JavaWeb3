package com.shf.mvc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class computedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double n1 = Double.valueOf(req.getParameter("n1"));
        Double n2 = Double.valueOf(req.getParameter("n2"));
        Double sum = n1 + n2;
        Double sub = n1 - n2;
        Double div = n1 / n2;
        Double mul = n1 * n2;
        Double mod = n1 % n2;
        req.setAttribute("n1",n1);
        req.setAttribute("n2",n2);
        req.setAttribute("sum",sum);
        req.setAttribute("sub",sub);
        req.setAttribute("divv",div);
        req.setAttribute("mul",mul);
        req.setAttribute("modd",mod);
        req.getRequestDispatcher("/demo7/computed.jsp").forward(req,resp);
    }
}
