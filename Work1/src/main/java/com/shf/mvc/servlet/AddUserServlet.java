package com.shf.mvc.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import static com.shf.mvc.beans.DbBean.addUser;

public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req);
        req.setCharacterEncoding("UTF-8");
        String bh = req.getParameter("bh");
        String xh = req.getParameter("xh");
        String xm = req.getParameter("xm");
        String yw = req.getParameter("yw");
        String sx = req.getParameter("sx");
        String yy = req.getParameter("yy");
        String zf = String.valueOf(Double.parseDouble(yw)+Double.parseDouble(sx)+Double.parseDouble(yy));

        try {
            addUser(Arrays.asList(xh,xm,bh,sx,yy,yw,zf));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        HttpSession session = req.getSession();
        session.setAttribute("xm",xm);
        req.getRequestDispatcher("/demo6/protect/success.jsp").forward(req,resp);
    }
}
