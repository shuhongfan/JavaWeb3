package cn.itcast.travel.web.servlet;

import cn.itcast.travel.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "activeUserServlet", value = "/activeUserServlet")
public class activeUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.获取激活码
        String code = request.getParameter("code");
        if (code!=null) {
//            2.调用service完成激活
            UserServiceImpl userService = new UserServiceImpl();
            boolean flag = userService.active(code);

            String msg=null;
            if (flag){
                msg="激活成功，请 <a href='login.html'>登录</a>";
            } else {
                msg = "激活失败，请联系管理员";
            }
//            相应数据
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
