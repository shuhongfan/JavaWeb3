package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

public interface RouteImgDao {
//    根据 route的id查询图片
    public List<RouteImg> findByRid(int rid);
}
