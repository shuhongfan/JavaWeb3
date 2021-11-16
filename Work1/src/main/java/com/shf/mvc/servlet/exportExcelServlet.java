package com.shf.mvc.servlet;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class exportExcelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException  {
//        刚刚上传的文件路径
        String filename = req.getParameter("filename");

        //创建一个list 用来存储读取的内容
        List list = new ArrayList();
        Workbook rwb = null;
        Cell cell = null;

        //创建输入流
        InputStream stream = new FileInputStream("D:\\DEMO\\JavaWeb3\\Work1\\target\\Work1-1.0-SNAPSHOT\\upload\\"+filename);

        //获取Excel文件对象
        try {
            rwb = Workbook.getWorkbook(stream);
        } catch (BiffException e) {
            e.printStackTrace();
        }

        //获取文件的指定工作表 默认的第一个
        Sheet sheet = rwb.getSheet(0);

        //行数(表头的目录不需要，从1开始)
        for(int i=0; i<sheet.getRows(); i++){

            //创建一个数组 用来存储每一列的值
            String[] str = new String[sheet.getColumns()];

            //列数
            for(int j=0; j<sheet.getColumns(); j++){

                //获取第i行，第j列的值
                cell = sheet.getCell(j,i);
                str[j] = cell.getContents();

            }
            //把刚获取的列存入list
            list.add(str);
        }
//        for(int i=0;i<list.size();i++){
//            String[] str = (String[])list.get(i);
//            for(int j=0;j<str.length;j++){
//                System.out.println(str[j]);
//            }
//        }
        req.setAttribute("list",list);
        req.getRequestDispatcher("/demo9/excel.jsp").forward(req,response);
    }
}
