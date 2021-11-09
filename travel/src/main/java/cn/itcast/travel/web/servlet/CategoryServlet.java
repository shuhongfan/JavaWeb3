package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.service.impl.CategoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "categoryServlet", value = "/category/*")
public class CategoryServlet extends BaseServlet {
    private CategoryService categoryService = new CategoryServiceImpl();

//    查询所有
    public void findAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
//        1.调用service查询所有
        List<Category> cs = categoryService.findAll();
//        2.序列化json返回
//        ObjectMapper mapper = new ObjectMapper();
//        response.setContentType("application/json; charset=UTF-8");
//        mapper.writeValue(response.getOutputStream(),cs);
        writeValue(cs,response);
    }
}
