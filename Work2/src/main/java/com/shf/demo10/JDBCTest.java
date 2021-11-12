package com.shf.demo10;

import org.junit.Test;

import java.sql.SQLException;
import java.util.*;

public class JDBCTest {
    JDBCUtils jdbcUtils = new JDBCUtils();

    @Test
    public void insert() throws SQLException {
        String sql = "insert into books (id,name, author,publisher,publicationDate,price) values (?,?,?,?,?,?), (?,?,?,?,?,?), (?,?,?,?,?,?)";
		List<Object> params = new ArrayList<>();
		Book b1 = new Book("9787212058937", "有理想就有疼痛", "高晓春", "安徽人民出版社", new Date(2019 / 12 / 20), 29.00);
		Book b2 = new Book("9787115402547","SVG精髓","(美) 艾森伯格 (Eisenberg,J.D.)","人民邮电出版社",new Date(2020/12/20),71.24);
		Book b3 = new Book("9787115429674","Linux命令行与shell脚本编程大全","(美) 布鲁姆 (Richard Blum) , (美)","人民邮电出版社",new Date(2209/12/20),99.19);
		params.add(b1.getId());
		params.add(b1.getName());
		params.add(b1.getAuthor());
		params.add(b1.getPublisher());
		params.add(b1.getPublicationDate());
		params.add(b1.getPrice());
		params.add(b2.getId());
		params.add(b2.getName());
		params.add(b2.getAuthor());
		params.add(b2.getPublisher());
		params.add(b2.getPublicationDate());
		params.add(b2.getPrice());
		params.add(b3.getId());
		params.add(b3.getName());
		params.add(b3.getAuthor());
		params.add(b3.getPublisher());
		params.add(b3.getPublicationDate());
		params.add(b3.getPrice());
		boolean flag = jdbcUtils.updateByPreparedStatement(sql,params);
		System.out.println(flag);
		if (flag){
			System.out.println("添加成功，添加的书籍信息为："+b1+""+b2+""+b3);
		} else {
			System.out.println("添加失败");
		}
    }

	@Test
	public void delete() throws SQLException {
		String sql = "delete from books where id = ?";
		List<Object> params = new ArrayList<Object>();
		params.add("9787212058937");
		boolean flag = jdbcUtils.updateByPreparedStatement(sql, params);
		System.out.println(flag);
		if (flag){
			System.out.println("删除成功，删除的书籍ID为："+params.get(0));
		} else {
			System.out.println("删除失败");
		}
	}

	@Test
	public void alter() throws SQLException {
		String sql = "update books set price = ? where id = ? ";
		List<Object> params = new ArrayList<Object>();
		params.add("99.9");
		params.add("9787212058937");
		boolean flag = jdbcUtils.updateByPreparedStatement(sql, params);
		System.out.println(flag);
		if (flag){
			System.out.println("修改成功，修改的书籍ID为："+params.get(1));
		} else {
			System.out.println("修改失败");
		}
	}

	@Test
	public void selects() throws SQLException {
		String sql = "select * from  books";
		List<Map<String, Object>> list = jdbcUtils.findModeResult(sql, null);
		if (list.size()!=0){
			System.out.println("查询成功，书籍的信息为："+list);
		} else {
			System.out.println("查询失败，没有此书信息");
		}
	}

	@Test
	public void select() throws SQLException {
		String sql = "select * from  books where id=?";
		List<Object> params = new ArrayList<Object>();
		params.add("9787115429674");
		Map<String, Object> list = jdbcUtils.findSimpleResult(sql, params);
		if (list.size()!=0){
			System.out.println("查询成功，书籍的信息为："+list);
		} else {
			System.out.println("查询失败，没有此书信息");
		}
	}
}
