package com.simplefanc.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 一个servlet要以某种方式处理客户端的请求，必须配置路径
 */
@WebServlet(urlPatterns = "/myservlet4")
public class MyServlet4 extends HttpServlet {
    // 实际开发时，一般会重写两个方法
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("i am HttpServlet");
    }
}
