package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "RouteServlet", value = "/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService service = new RouteServiceImpl();
    private FavoriteService favoriteService = new FavoriteServiceImpl();

    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        获取参数
        String currentPageStr = request.getParameter("currentPage");
        String pageSizeStr = request.getParameter("pageSize");
        String cidStr = request.getParameter("cid");
        String rname = request.getParameter("rname");
        rname = new String(rname.getBytes("iso-8859-1"),"utf-8");

        int cid = 0;
        int currentPage = 0;
        int pagesize = 0;
        if (cidStr !=null && cidStr.length()>0 && !"null".equals(cidStr)) {
            cid=Integer.parseInt(cidStr);
        }
//        当前页码 如果不传递，则默认为第一页
        if (currentPageStr !=null && currentPageStr.length()>0) {
            currentPage=Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
//        每页显示条数，如果不传，默认显示5条数据
        if (pageSizeStr !=null && pageSizeStr.length()>0) {
            pagesize=Integer.parseInt(pageSizeStr);
        } else {
            pagesize = 5;
        }

//        3.调用service查询pageBean对象
        PageBean<Route> pb = service.pageQuery(cid, currentPage, pagesize,rname);
//        4.将pageBean对象序列化json 方法
        writeValue(pb,response);
    }

//    根据id查询一个旅游线路的详细信息
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.接收id
        String rid = request.getParameter("rid");
//        2.调用service查询route对象
        Route route = service.findOne(rid);
//        3.转为json写回客户端
        writeValue(route,response);
    }

//    判断当前登录用户是否收藏过该线路
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.获取线路id
        String rid = request.getParameter("rid");

//        2.获取当前登录 user
        User user = (User) request.getSession().getAttribute("user");
//        用户id
        int uid;
        if (user==null) uid=0;
        else uid= user.getUid();

//        3.调用favoriteService查询是否收藏
        boolean flag = favoriteService.isFavorite(rid, uid);
//        4.写回客户端
        writeValue(flag,response);
    }

//    添加收藏
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1. 获取线路rid
        String rid = request.getParameter("rid");
//        2.获取当前登录用户
        User user = (User) request.getSession().getAttribute("user");
        if (user==null) return;
        int uid = user.getUid();
//      3.调用service添加
        favoriteService.add(rid,uid);
    }
}
