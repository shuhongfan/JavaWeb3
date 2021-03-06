package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.获取用户名和密码数据
        Map<String, String[]> map = request.getParameterMap();
//        2.封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        3.调用service查询
        UserServiceImpl service = new UserServiceImpl();
        User u = service.login(user);
//        4.判断
        ResultInfo info = new ResultInfo();
        if (u==null){
//            用户名密码错误
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误");
        }
        if (u!=null && !"Y".equals(u.getStatus())){
//            用户尚未激活
            info.setFlag(false);
            info.setErrorMsg("您尚未激活，请激活");
        }
        if (u!=null && "Y".equals(u.getStatus())){
//            登录成功
            info.setFlag(true);
            request.getSession().setAttribute("user",u);//登录成功标记
        }
//        响应数据
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),info);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
