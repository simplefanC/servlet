package com.simplefanc.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * 一个servlet要以某种方式处理客户端的请求，必须配置路径
 */
//加上这个注解，称为一个servlet组件，拥有处理请求的能力
//必须定义urlPattern url匹配模式;value等同于urlPattern
@WebServlet(urlPatterns = "/love", loadOnStartup = 1)
public class MyServlet1 implements Servlet {

    public MyServlet1() {
        System.out.println("s1构造");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //对外提供服务的方法
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //内容写出去，输出流
        /**
         * req 请求
         * res 回复
         */
        servletResponse.setContentType("text/html; charset=UTF-8");
        servletResponse.getWriter().write("美丽的菲菲");//字符流
//        servletResponse.getOutputStream();//字节流

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
